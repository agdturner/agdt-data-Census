/**
 * A component of a library for
 * <a href="http://www.geog.leeds.ac.uk/people/a.turner/projects/MoSeS">MoSeS</a>.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.
 */
package uk.ac.leeds.ccg.andyt.census.cas;

import uk.ac.leeds.ccg.andyt.census.core.Census_AbstractHandler;
import uk.ac.leeds.ccg.andyt.census.core.Census_AbstractDataRecord;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;
import uk.ac.leeds.ccg.andyt.census.core.Census_Environment;
import uk.ac.leeds.ccg.andyt.generic.core.Generic_ErrorAndExceptionHandler;

/**
 * A <code>class</code> for handling an individual
 * <code>Census_CAS044DataRecord</code> and collections of
 * <code>CAS044DataRecords</code>.
 * <ul>
 * <li>Used for formatting source data and testing it can be loaded to and
 * retrieved from a formatted file.</li>
 * <li>Developed for <a href="http://www.ncess.ac.uk/moses">MoSeS</a>.</li>
 * <li>Copyright (C) 2006 <a
 * href="http://www.geog.leeds.ac.uk/people/a.turner/">Andy Turner</a>, <a
 * href="http://www.leeds.ac.uk//">University of Leeds</a>.</li>
 * </ul>
 *
 * @author <a href="http://www.geog.leeds.ac.uk/people/a.turner/">Andy
 * Turner</a>
 * @version 1.0.0, 2007-05-24
 * @see Census_AbstractDataRecord
 */
public class Census_CAS044DataHandler extends Census_AbstractHandler {

    /**
     * Creates a new instance of <code>CAS044DataHandler</code> for handling
     * CAS044DataRecords stored in a formatted <code>File</code> The default
     * <code>File</code> is hard coded. To specify the <code>File</code> use
     * <code>CAS044DataHandler(File)</code>. To set a different default
     * <code>File</code> edit the source code and recompile.
     *
     * @throws java.io.IOException
     */
    public Census_CAS044DataHandler(Census_Environment e) throws IOException {
        super (e);
//        // this( new File(
//        // "C:/Work/Projects/MoSeS/Workspace/CAS044DataRecords.dat" ) );
//        // Want also to setDirectory();
//        // initMemoryReserve();
//        // Default this.directory, this.file, this.randomAccessFile
//        File directory = new File("C:/Work/Projects/MoSeS/Workspace/");
//        this.init(directory);
//        this.file = new File(directory, "CAS044DataRecords.dat");
//        if (!this.file.exists()) {
//            this.file.createNewFile();
//        }
//        this.recordLength = new Census_CAS044DataRecord().getSizeInBytes();
//        // System.out.println("this.recordLength " + this.recordLength);
//        this.rAF = new RandomAccessFile(this.file, "r");
    }

//    /**
//     * Creates a new instance of CAS044DataHandler with Records loaded from
//     * formattedFile.
//     *
//     * @param formattedFile Formatted file of CAS044DataRecords
//     * @throws java.io.IOException
//     */
//    public Census_CAS044DataHandler(File formattedFile) throws IOException {
//        // initMemoryReserve();
//        this.init(formattedFile.getParentFile());
//        this.recordLength = new Census_CAS044DataRecord().getSizeInBytes();
//        load(formattedFile);
//        System.out.println("CAS044DataRecords loaded successfully");
//    }

    /**
     * Loads <code>CAS001DataRecords</code> and prints out n randomly
     *
     * @param directory to load source data from
     * @param n the number of loaded data records to print out.
     * @throws java.io.IOException
     */
    protected void formatSourceData(
            File directory,
            int n)
            throws IOException {
        rAF = new RandomAccessFile(this.file, "rw");
        File infile;
        long long0 = 0L;
        long RecordID = 0L;
        // Load England
        infile = new File(
                directory,
                "CAS044EnglandOA.csv");
        RecordID = format(infile, RecordID);
        System.out.println(infile.toString() + " formatted successfully " + RecordID + " records"); // 165665
        long0 = RecordID;
        // Load Wales
        infile = new File(
                directory,
                "CAS044WalesOA.csv");
        RecordID = format(infile, RecordID);
        System.out.println(infile.toString() + " formatted successfully " + (RecordID - long0) + " records"); // 9769
        long0 = RecordID;
        // Load Scotland
        infile = new File(
                directory,
                "CAS044ScotlandOA.csv");
        RecordID = format(infile, RecordID);
        System.out.println(infile.toString() + " formatted successfully " + (RecordID - long0) + " records"); // 42604
        long0 = RecordID;
        // Table not available for Northern Ireland
        print(20, new Random());
    }

    /**
     * Uses a <code>BufferedReader<code> and a <code>StreamTokenizer</code> to
     * read lines from the sourceFile <code>File</code>. The lines are converted
     * to <code>CAS044DataRecords</code> and written to <code>this.rAF</code>.
     *
     * @param sourceFile The source CAS044DataRecords file to be formatted and
     * written to <code>this.rAF</code>.
     * @param RecordID The <code>RecordID</code> to assign to the first
     * <code>Census_CAS044DataRecord</code>.
     * @return The <code>RecordID</code> assigned to the last
     * <code>CAS044DataRecords</code>.
     * @throws java.io.IOException
     */
    protected long format(File sourceFile, long RecordID) throws IOException {
        System.out.println("format( File( " + sourceFile.toString() + " ), RecordID( " + RecordID + " ))");
        BufferedReader br = env.env.io.getBufferedReader(sourceFile);
        StreamTokenizer st = new StreamTokenizer(br);
        env.env.io.setStreamTokenizerSyntax1(st);
        String string0 = new String();
        String string1;
        String string2;
        long long0;
        long longZero = 0L;
        Census_CAS044DataRecord rec = new Census_CAS044DataRecord();
        boolean print = false;
        int int10000 = 10000;
        // Skip the first line
        int tokenType = st.nextToken();
        while (tokenType != StreamTokenizer.TT_EOL) {
            tokenType = st.nextToken();
        }
        tokenType = st.nextToken();
        while (tokenType != StreamTokenizer.TT_EOF) {
            switch (tokenType) {
                case StreamTokenizer.TT_EOL:
                    long0 = RecordID % int10000;
                    print = (long0 == longZero);
                    if (print) {
                        string2 = rec.toString();
                        System.out.println(string2);
                        string2 = string0;
                    }
                    // Write out
                    rec.write(rAF);
                    RecordID++;
                    break;
                case StreamTokenizer.TT_WORD:
                    string1 = st.sval;
                    rec = new Census_CAS044DataRecord(RecordID, string1);
                    break;
            }
            string1 = string0;
            tokenType = st.nextToken();
        }
        System.out.println("Number of Records loaded = " + RecordID);
        return RecordID;
    }

    /**
     * @return a <code>Census_CAS044DataRecord</code> with
     * <code>Census_AbstractDataRecord.RecordID = RecordID</code>
     * @param RecordID The RecordID of the Census_CAS044DataRecord to be
     * returned.
     */
    public Census_AbstractDataRecord getDataRecord(long RecordID) {
        return getCAS044DataRecord(RecordID);
    }

    /**
     * @return a <code>Census_CAS044DataRecord</code> with
     * <code>Census_CAS044DataRecord.RecordID = RecordID</code>
     * @param RecordID The RecordID of the Census_CAS044DataRecord to be
     * returned.
     */
    public Census_CAS044DataRecord getCAS044DataRecord(long RecordID) {
        Census_CAS044DataRecord result = null;
        try {
            this.rAF.seek(recordLength * RecordID);
            result = new Census_CAS044DataRecord(this.rAF);
        } catch (IOException aIOException) {
            env.env.log(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
        return result;
    }

    /**
     * Aggregates <code>CAS044DataRecords</code> from OA To Ward for the OA
     * records in the range [startRecordID,endRecordID] and writes the results
     * to aRandomAccessFile
     *
     * @param aRandomAccessFile <code>RandomAccessFile</code> to which results
     * are written
     * @param startRecordID The first OA RecordID in the sequence to be
     * aggregated.
     * @param endRecordID The last OA RecordID in the sequence to be aggregated.
     * @throws java.io.IOException
     */
    public void aggregateOAToWard(RandomAccessFile aRandomAccessFile,
            long startRecordID, long endRecordID) throws IOException {
        TreeMap result = new TreeMap();
        Census_CAS044DataRecord aCAS044DataRecord;
        Census_CAS044DataRecord bCAS044DataRecord;
        String zoneCode;
        Object zoneCodeWard;
        // long newRecordID = startRecordIDForLeeds - 1L;
        long newRecordID = -1L;
        for (long RecordID = startRecordID; RecordID < endRecordID; RecordID++) {
            aCAS044DataRecord = (Census_CAS044DataRecord) getDataRecord(RecordID);
            zoneCode = new String(aCAS044DataRecord.getZone_Code());
            zoneCodeWard = zoneCode.substring(0, 6);
            if (result.containsKey(zoneCodeWard)) {
                bCAS044DataRecord = (Census_CAS044DataRecord) result.get(zoneCodeWard);
                result.remove(zoneCodeWard);
                result.put(zoneCodeWard, aCAS044DataRecord.aggregate(bCAS044DataRecord));
            } else {
                result.put(zoneCodeWard, aCAS044DataRecord);
            }
        }
        //write(aRandomAccessFile, result);
    }

    /**
     * Aggregates <code>CAS044DataRecords</code> from OA To MSOA for the OA
     * records in the range [startRecordID,endRecordID] and writes the results
     * to aRandomAccessFile
     *
     * @param aRandomAccessFile <code>RandomAccessFile</code> to which results
     * are written
     * @param startRecordID The first OA RecordID in the sequence to be
     * aggregated.
     * @param endRecordID The last OA RecordID in the sequence to be aggregated.
     * @throws java.io.IOException
     */
    public void aggregateOAToMSOA(RandomAccessFile aRandomAccessFile,
            long startRecordID, long endRecordID) throws IOException {
        TreeMap result = new TreeMap();
        HashMap lookUpMSOAfromOAHashMap = null;//getOA2MSOA();
        Census_CAS044DataRecord aCAS044DataRecord;
        Census_CAS044DataRecord bCAS044DataRecord;
        String zoneCode;
        Object zoneCodeMSOA;
        // long newRecordID = startRecordIDForLeeds - 1L;
        long newRecordID = -1L;
        for (long RecordID = startRecordID; RecordID < endRecordID; RecordID++) {
            aCAS044DataRecord = (Census_CAS044DataRecord) getDataRecord(RecordID);
            zoneCode = new String(aCAS044DataRecord.getZone_Code());
            zoneCodeMSOA = lookUpMSOAfromOAHashMap.get(zoneCode);
            if (result.containsKey(zoneCodeMSOA)) {
                bCAS044DataRecord = (Census_CAS044DataRecord) result.get(zoneCodeMSOA);
                result.remove(zoneCodeMSOA);
                result.put(zoneCodeMSOA, aCAS044DataRecord.aggregate(bCAS044DataRecord));
            } else {
                result.put(zoneCodeMSOA, aCAS044DataRecord);
            }
        }
        //write(aRandomAccessFile, result);
    }
}
