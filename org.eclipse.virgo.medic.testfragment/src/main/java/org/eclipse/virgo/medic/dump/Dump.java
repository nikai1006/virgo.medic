/*******************************************************************************
 * Copyright (c) 2008, 2010 VMware Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   VMware Inc. - initial contribution
 *******************************************************************************/

package org.eclipse.virgo.medic.dump;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Map;

/**
 * A <code>Dump</code> represents a dump being generated by a {@link DumpGenerator}. During dump generation
 * {@link DumpContributor DumpContributors} are called to contribute to the dump. Contributors can request a
 * {@link Writer}, {@link File}, etc. which they may use to write out their contribution to the dump.
 */
public interface Dump {

    /**
     * Returns a timestamp that identifies that time at which this dump was generated.
     * 
     * @return The timestamp of the dump's generation
     */
    long getTimestamp();

    /**
     * Returns the context that is associated with this dump. If there is no associated context an empty
     * <code>Map</code> is returned.
     * 
     * @return The dump's context
     */
    Map<String, Object> getContext();

    /**
     * Returns the {@link Throwable Throwables} associated with this dump.
     * 
     * @return The dump's <code>Throwable</code>s
     */
    Throwable[] getThrowables();

    /**
     * Returns the cause of this dump.
     * 
     * @return The dump's cause.
     */
    String getCause();

    /**
     * Creates a {@link FileWriter} that writes to a file with the supplied name, within this dump's output location.
     * @param name 
     * 
     * @return a <code>FileWriter</code> to which a contribution to the dump can be written
     * @throws DumpContributionFailedException 
     */
    FileWriter createFileWriter(String name) throws DumpContributionFailedException;

    /**
     * Creates a {@link FileOutputStream} that writes to a file with the supplied name, within this dump's output
     * location.
     * @param name 
     * 
     * @return a <code>FileOutputStream</code> to which a contribution to the dump can be written
     * @throws DumpContributionFailedException 
     */
    FileOutputStream createFileOutputStream(String name) throws DumpContributionFailedException;

    /**
     * Creates a {@link File} with the supplied name, within this dump's output location.
     * @param name 
     * 
     * @return a <code>File</code> to which a contribution to the dump can be written
     */
    File createFile(String name);

}
