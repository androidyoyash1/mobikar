/*
 * @(#)MidiFileReader.java	1.13 03/12/19
 *
 * Copyright 2004 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package karparser;	

import java.io.File;
import java.io.InputStream;
import java.io.IOException;
import java.net.URL;


/**
 * A <code>MidiFileReader</code> supplies MIDI file-reading services.  Classes implementing this
 * interface can parse the format information from one or more types of
 * MIDI file, and can produce a <code>Sequence</code> object from files of these types.
 *
 * @author Kara Kytle
 * @version 1.13 03/12/19
 * @since 1.3
 */
public abstract class MidiFileReader {

    /**
     * Obtains the MIDI file format of the input stream provided.  The stream must
     * point to valid MIDI file data.  In general, MIDI file readers may 
     * need to read some data from the stream before determining whether they
     * support it.  These parsers must
     * be able to mark the stream, read enough data to determine whether they 
     * support the stream, and, if not, reset the stream's read pointer to its original 
     * position.  If the input stream does not support this, this method may fail
     * with an <code>IOException</code>. 
     * @param stream the input stream from which file format information should be
     * extracted
     * @return a <code>MidiFileFormat</code> object describing the MIDI file format
     * @throws Exception if the stream does not point to valid MIDI
     * file data recognized by the system
     * @throws IOException if an I/O exception occurs
     * @see InputStream#markSupported
     * @see InputStream#mark
     */
    public abstract MidiFileFormat getMidiFileFormat(InputStream stream) throws Exception, IOException;


    /**
     * Obtains the MIDI file format of the URL provided.  The URL must
     * point to valid MIDI file data.
     * @param url the URL from which file format information should be
     * extracted
     * @return a <code>MidiFileFormat</code> object describing the MIDI file format
     * @throws Exception if the URL does not point to valid MIDI
     * file data recognized by the system
     * @throws IOException if an I/O exception occurs
     */
    public abstract MidiFileFormat getMidiFileFormat(URL url) throws Exception, IOException;


    /**
     * Obtains the MIDI file format of the <code>File</code> provided.  
     * The <code>File</code> must point to valid MIDI file data.
     * @param file the <code>File</code> from which file format information should be
     * extracted
     * @return a <code>MidiFileFormat</code> object describing the MIDI file format
     * @throws Exception if the <code>File</code> does not point to valid MIDI
     * file data recognized by the system
     * @throws IOException if an I/O exception occurs
     */
    public abstract MidiFileFormat getMidiFileFormat(File file) throws Exception, IOException;


    /**
     * Obtains a MIDI sequence from the input stream provided.  The stream must
     * point to valid MIDI file data.  In general, MIDI file readers may 
     * need to read some data from the stream before determining whether they
     * support it.  These parsers must
     * be able to mark the stream, read enough data to determine whether they 
     * support the stream, and, if not, reset the stream's read pointer to its original 
     * position.  If the input stream does not support this, this method may fail
     * with an IOException. 
     * @param stream the input stream from which the <code>Sequence</code> should be
     * constructed
     * @return a <code>Sequence</code> object based on the MIDI file data contained
     * in the input stream.
     * @throws Exception if the stream does not point to valid MIDI
     * file data recognized by the system
     * @throws IOException if an I/O exception occurs
     * @see InputStream#markSupported
     * @see InputStream#mark
     */
    public abstract Sequence getSequence(InputStream stream) throws Exception, IOException;


    /**
     * Obtains a MIDI sequence from the URL provided.  The URL must
     * point to valid MIDI file data.
     * @param url the URL for which the <code>Sequence</code> should be
     * constructed
     * @return a <code>Sequence</code> object based on the MIDI file data pointed
     * to by the URL
     * @throws Exception if the URL does not point to valid MIDI
     * file data recognized by the system
     * @throws IOException if an I/O exception occurs
     */
    public abstract Sequence getSequence(URL url) throws Exception, IOException;


    /**
     * Obtains a MIDI sequence from the <code>File</code> provided.  The <code>File</code> must
     * point to valid MIDI file data.
     * @param file the <code>File</code> from which the <code>Sequence</code> should be
     * constructed
     * @return a <code>Sequence</code> object based on the MIDI file data pointed
     * to by the <code>File</code>
     * @throws Exception if the <code>File</code> does not point to valid MIDI
     * file data recognized by the system
     * @throws IOException if an I/O exception occurs
     */
    public abstract Sequence getSequence(File file) throws Exception, IOException;
}
