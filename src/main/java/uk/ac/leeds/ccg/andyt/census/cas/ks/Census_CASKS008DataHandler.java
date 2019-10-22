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
package uk.ac.leeds.ccg.andyt.census.cas.ks;

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
import uk.ac.leeds.ccg.andyt.census.core.Census_AbstractHandler;
import uk.ac.leeds.ccg.andyt.census.core.Census_AbstractDataRecord;
import uk.ac.leeds.ccg.andyt.census.core.Census_Environment;
import uk.ac.leeds.ccg.andyt.generic.core.Generic_ErrorAndExceptionHandler;

/**
 * A <code>class</code> for handling an individual
 * <code>CASKS006DataRecord</code> and collections of
 * <code>CASKS006DataRecords</code>.
 */
public class Census_CASKS008DataHandler extends Census_AbstractHandler {

    public Census_CASKS008DataHandler(Census_Environment e) throws IOException {
        super (e);
        File directory = new File("C:/Work/Projects/MoSeS/Workspace/");
        try {
            this.file = new File(directory, "CASKS008DataRecords.dat");
            if (!this.file.exists()) {
                this.file.createNewFile();
            }
            this.recordLength = new Census_CASKS008DataRecord().getSizeInBytes();
            // env.env.log("this.recordLength " + this.recordLength);
            this.rAF = new RandomAccessFile(this.file, "r");
        } catch (IOException aIOException) {
            env.env.log(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
    }

//    public Census_CASKS008DataHandler(File formattedFile) {
//        // initMemoryReserve();
//        this.init(formattedFile.getParentFile());
//        this.recordLength = new Census_CASKS008DataRecord().getSizeInBytes();
//        load(formattedFile);
//        env.env.log("CASKS008DataRecords loaded successfully");
//    }

    public void formatSourceData(
            File directory,
            int n) {
        try {
            rAF = new RandomAccessFile(this.file, "rw");
            File infile;
            long long0 = 0L;
            long RecordID = 0L;
            // Load England
            infile = new File(
                    directory,
                    "KS008EnglandOA.csv");
            RecordID = format(infile, RecordID);
            env.env.log(infile.toString() + " formatted successfully " + RecordID + " records"); // 165665
            long0 = RecordID;
            // Load Wales
            infile = new File(
                    directory,
                    "KS008WalesOA.csv");
            RecordID = format(infile, RecordID);
            env.env.log(infile.toString() + " formatted successfully " + (RecordID - long0) + " records"); // 9769
            long0
                    = RecordID;
            // Load Scotland
            infile = new File(
                    directory,
                    "KS008ScotlandOA.csv");
            RecordID = format(infile, RecordID);
            env.env.log(infile.toString() + " formatted successfully " + (RecordID - long0) + " records"); // 42604
            long0 = RecordID;
            // Load Northern Ireland
            infile = new File(
                    directory,
                    "KS008NorthernIrelandOA.csv");
            RecordID = format(infile, RecordID);
            env.env.log(infile.toString() + " formatted successfully " + (RecordID - long0) + " records"); // 5022
            rAF.close();
            load(file);
            print(20, new Random());
        } catch (IOException aIOException) {
            env.env.log(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
    }

    protected long format(File sourceFile, long RecordID) {
        try {
            BufferedReader br = env.env.io.getBufferedReader(sourceFile);
            StreamTokenizer st = new StreamTokenizer(br);
            env.env.io.setStreamTokenizerSyntax1(st);
            String string0 = new String();
            String string1;
            String string2;
            long long0;
            long longZero = 0L;
            Census_CASKS008DataRecord rec = new Census_CASKS008DataRecord();
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
                            env.env.log(string2);
                            string2 = string0;
                        }
                        rec.write(rAF);
                        RecordID++;
                        break;
                    case StreamTokenizer.TT_WORD:
                        string1 = st.sval;
                        rec  = new Census_CASKS008DataRecord(RecordID, string1);
                        break;
                }
                string1 = string0;
                tokenType
                        = st.nextToken();
            }
            env.env.log("Number of Records loaded = " + RecordID);
        } catch (IOException aIOException) {
            env.env.log(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
        return RecordID;
    }

    /**
     * @return a <code>Census_CASKS008DataRecord</code> with
     * <code>Census_AbstractDataRecord.RecordID = RecordID</code>
     * @param RecordID The RecordID of the Census_CASKS008DataRecord to be
     * returned.
     */
    public Census_AbstractDataRecord getDataRecord(
            long RecordID) {
        return getCASKS008DataRecord(RecordID);
    }

    /**
     * @return a <code>Census_CASKS008DataRecord</code> with
     * <code>Census_CASKS008DataRecord.RecordID = RecordID</code>
     * @param RecordID The RecordID of the Census_CASKS008DataRecord to be
     * returned.
     */
    public Census_CASKS008DataRecord getCASKS008DataRecord(
            long RecordID) {
        Census_CASKS008DataRecord result = null;
        try {
            this.rAF.seek(recordLength * RecordID);
            result
                    = new Census_CASKS008DataRecord(this.rAF);
        } catch (IOException aIOException) {
            System.err.println(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }

        return result;
    }

    /**
     * Aggregates <code>CASKS008DataRecords</code> from OA To Ward for the OA
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
    public void aggregateOAToWard(
            RandomAccessFile aRandomAccessFile,
            long startRecordID,
            long endRecordID) throws IOException {
        TreeMap result = new TreeMap();
        Census_CASKS008DataRecord aCASKS008DataRecord;

        Census_CASKS008DataRecord bCASKS008DataRecord;

        String zoneCode;

        Object zoneCodeWard;
// long newRecordID = startRecordIDForLeeds - 1L;

        long newRecordID = -1L;
        for (long RecordID = startRecordID; RecordID
                < endRecordID; RecordID++) {
            aCASKS008DataRecord = (Census_CASKS008DataRecord) getDataRecord(RecordID);
            zoneCode
                    = new String(aCASKS008DataRecord.getZone_Code());
            zoneCodeWard
                    = zoneCode.substring(0, 6);
            if (result.containsKey(zoneCodeWard)) {
                bCASKS008DataRecord = (Census_CASKS008DataRecord) result.get(zoneCodeWard);
                result.remove(zoneCodeWard);
                result.put(zoneCodeWard, aCASKS008DataRecord.aggregate(bCASKS008DataRecord));
            } else {
                newRecordID++;
                result.put(zoneCodeWard, aCASKS008DataRecord);
            }

        }
        //write(aRandomAccessFile, result);
    }

    /**
     * Aggregates <code>CASKS008DataRecords</code> from OA To MSOA for the OA
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
        boolean handleOutOfMemoryError = true;
        HashMap lookUpMSOAfromOAHashMap = null;//getOA2MSOA();
        Census_CASKS008DataRecord aCASKS008DataRecord;

        Census_CASKS008DataRecord bCASKS008DataRecord;

        String zoneCode;

        Object zoneCodeMSOA;
// long newRecordID = startRecordIDForLeeds - 1L;

        long newRecordID = -1L;
        for (long RecordID = startRecordID; RecordID
                < endRecordID; RecordID++) {
            aCASKS008DataRecord = (Census_CASKS008DataRecord) getDataRecord(RecordID);
            zoneCode
                    = new String(aCASKS008DataRecord.getZone_Code());
            zoneCodeMSOA
                    = lookUpMSOAfromOAHashMap.get(zoneCode);
            if (result.containsKey(zoneCodeMSOA)) {
                bCASKS008DataRecord = (Census_CASKS008DataRecord) result.get(zoneCodeMSOA);
                result.remove(zoneCodeMSOA);
                result.put(zoneCodeMSOA, aCASKS008DataRecord.aggregate(bCASKS008DataRecord));
            } else {
                newRecordID++;
                result.put(zoneCodeMSOA, aCASKS008DataRecord);
            }

        }
        //write(aRandomAccessFile, result);
    }
}
