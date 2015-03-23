/**
 * A component of a library for
 * <a href="http://www.geog.leeds.ac.uk/people/a.turner/projects/MoSeS">MoSeS</a>.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA.
 */
package uk.ac.leeds.ccg.andyt.agdtcensus.cas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.StreamTokenizer;
import java.util.HashMap;
import uk.ac.leeds.ccg.andyt.generic.core.Generic_ErrorAndExceptionHandler;
import uk.ac.leeds.ccg.andyt.generic.io.Generic_StaticIO;

/**
 * A <code>class</code> for handling an individual
 * <code>CASAreaEastingNorthingDataRecord</code> and collections of
 * <code>CASAreaEastingNorthingDataRecords</code>.
 */
public class CASAreaEastingNorthingDataHandler extends AbstractCASDataHandler {

    public CASAreaEastingNorthingDataHandler() {
        File directory = new File("C:/Work/Projects/GENESIS/Workspace/");
        init(directory);
        try {
            this._File = new File(directory, "CASAreaEastingNorthingDataRecords.dat");
            if (!this._File.exists()) {
                this._File.createNewFile();
            }
            this._RecordLength = new CASAreaEastingNorthingDataRecord().getSizeInBytes();
            // log("this.recordLength " + this.recordLength);
            this._RandomAccessFile = new RandomAccessFile(this._File, "r");
        } catch (IOException aIOException) {
            log(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
    }

    /**
     * Creates a new instance of CASAreaEastingNorthingDataHandler with Records loaded from
     * formattedFile.
     *
     * @param file Formatted file of CASAreaEastingNorthingDataRecords
     */
    public CASAreaEastingNorthingDataHandler(File file) {
        this.init(file.getParentFile());
        if (file.getName().endsWith("thisFile")) {
            CASAreaEastingNorthingDataHandler a_CASAreaEastingNorthingDataHandler;
            a_CASAreaEastingNorthingDataHandler = (CASAreaEastingNorthingDataHandler) Generic_StaticIO.readObject(file);
            this._File = a_CASAreaEastingNorthingDataHandler._File;
            load(_File);
        } else {
            load(file);
        }
        this._RecordLength = new CASAreaEastingNorthingDataRecord().getSizeInBytes();
        log("CASAreaEastingNorthingDataRecords loaded successfully");
    }

    /**
     * Loads <code>CAS001DataRecords</code> and prints out n randomly
     * @param directory to load source data from
     * @param n the number of loaded data records to print out.
     */
    public void formatSourceData(
            File directory,
            int n) {
        try {
            _RandomAccessFile = new RandomAccessFile(this._File, "rw");
            // Load from source
            File infile;
            long long0 = 0L;
            long RecordID = 0L;
            // Load England
            infile = new File(
                    directory,
                    "England_OA_ZoneCode_Area_Easting_Northing.csv");
            RecordID = format(infile, RecordID);
            log(infile.toString() + " formatted successfully " + RecordID + " records"); // 165665
            long0 = RecordID;
//            // Load Wales
//            infile = new File(
//                    directory,
//                    "Wales_OA_ZoneCode_Area_Easting_Northing.csv");
//            RecordID = format(infile, RecordID);
//            log(infile.toString() + " formatted successfully " + (RecordID - long0) + " records"); // 9769
//            long0 = RecordID;
//            // Load Scotland
//            infile = new File(
//                    directory,
//                    "Scotland_OA_ZoneCode_Area_Easting_Northing.csv");
//            RecordID = format(infile, RecordID);
//            log(infile.toString() + " formatted successfully " + (RecordID - long0) + " records"); // 42604
//            long0 = RecordID;
//            // Load Northern Ireland
//            infile = new File(
//                    directory,
//                    "NorthernIreland_OA_ZoneCode_Area_Easting_Northing.csv");
//            RecordID = format(infile, RecordID);
//            log(infile.toString() + " formatted successfully " + (RecordID - long0) + " records"); // 5022
//            _RandomAccessFile.close();
//            load(_File);
//            print(20, new Random());
        } catch (FileNotFoundException aIOException) {
            log(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
    }

    /**
     * Uses a <code>BufferedReader<code> and a <code>StreamTokenizer</code> to
     * read lines from the sourceFile <code>File</code>. The lines are converted
     * to <code>CASAreaEastingNorthingDataRecords</code> and written to
     * <code>this.tRandomAccessFile</code>.
     *
     * @param sourceFile
     *            The source CASAreaEastingNorthingDataRecords file to be formatted and
     *            written to <code>this.tRandomAccessFile</code>.
     * @param RecordID
     *            The <code>RecordID</code> to assign to the first
     *            <code>CASAreaEastingNorthingDataRecord</code>.
     * @return The <code>RecordID</code> assigned to the last
     *         <code>CASAreaEastingNorthingDataRecords</code>.
     */
    protected long format(
            File sourceFile,
            long RecordID) {
        try {
            BufferedReader aBufferedReader =
                    new BufferedReader(
                    new InputStreamReader(
                    new FileInputStream(sourceFile)));
            StreamTokenizer aStreamTokenizer = new StreamTokenizer(aBufferedReader);
            Generic_StaticIO.setStreamTokenizerSyntax1(aStreamTokenizer);
            String string0 = new String();
            String string1;
            String string2;
            long long0;
            long longZero = 0L;
            CASAreaEastingNorthingDataRecord aCASAreaEastingNorthingDataRecord = new CASAreaEastingNorthingDataRecord();
            boolean print = false;
            int int10000 = 10000;
            // Skip the first line
            int tokenType = aStreamTokenizer.nextToken();
            while (tokenType != StreamTokenizer.TT_EOL) {
                tokenType = aStreamTokenizer.nextToken();
            }
            tokenType = aStreamTokenizer.nextToken();
            while (tokenType != StreamTokenizer.TT_EOF) {
                switch (tokenType) {
                    case StreamTokenizer.TT_EOL:
                        long0 = RecordID % int10000;
                        print = (long0 == longZero);
                        if (print) {
                            string2 = aCASAreaEastingNorthingDataRecord.toString();
                            log(string2);
                            string2 = string0;
                        }
                        // Write out
                        aCASAreaEastingNorthingDataRecord.write(_RandomAccessFile);
                        RecordID++;
                        break;
                    case StreamTokenizer.TT_WORD:
                        string1 = aStreamTokenizer.sval;
                        aCASAreaEastingNorthingDataRecord = new CASAreaEastingNorthingDataRecord(RecordID, string1);
                        break;
                }
                string1 = string0;
                tokenType = aStreamTokenizer.nextToken();
            }
            log("Number of Records loaded = " + RecordID);
        } catch (IOException aIOException) {
            log(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
        return RecordID;
    }

    /**
     * @return a <code>CASAreaEastingNorthingDataRecord</code> with
     *         <code>AbstractCASDataRecord.RecordID = RecordID</code>
     * @param RecordID
     *            The RecordID of the CASAreaEastingNorthingDataRecord to be returned.
     */
    public AbstractCASDataRecord getDataRecord(long RecordID) {
        return getCASAreaEastingNorthingDataRecord(RecordID);
    }

    /**
     * @return a <code>CASAreaEastingNorthingDataRecord</code> with
     *         <code>CASAreaEastingNorthingDataRecord.RecordID = RecordID</code>
     * @param RecordID
     *            The RecordID of the CASAreaEastingNorthingDataRecord to be returned.
     */
    public CASAreaEastingNorthingDataRecord getCASAreaEastingNorthingDataRecord(
            long RecordID) {
        CASAreaEastingNorthingDataRecord result = null;
        try {
            this._RandomAccessFile.seek(_RecordLength * RecordID);
            result = new CASAreaEastingNorthingDataRecord(this._RandomAccessFile);
        } catch (IOException aIOException) {
            System.err.println(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
        return result;
    }

    public HashMap get_CASZoneCode_CASAreaEastingNorthingDataRecord_HashMap(String code) {
        HashMap _CASZoneCode_CASAreaEastingNorthingDataRecord_HashMap = new HashMap();
        CASAreaEastingNorthingDataRecord a_CASAreaEastingNorthingDataRecord;
        Object _Easting_Northing;
        for (long _RecordID = 0; _RecordID < getNDataRecords(); _RecordID++) {
            a_CASAreaEastingNorthingDataRecord = getCASAreaEastingNorthingDataRecord(_RecordID);
            String a_Zone_Code = new String(a_CASAreaEastingNorthingDataRecord.getZone_Code());
            if (a_Zone_Code.startsWith(code)) {
                //System.out.println(a_Zone_Code);
                _CASZoneCode_CASAreaEastingNorthingDataRecord_HashMap.put(
                        a_Zone_Code,
                        a_CASAreaEastingNorthingDataRecord);
            }
        }
        return _CASZoneCode_CASAreaEastingNorthingDataRecord_HashMap;
    }

//    public class EastingNorthing {
//        BigDecimal _Easting;
//        BigDecimal _Northing;
//
//        public EastingNorthing(){
//
//        }
//    }
}