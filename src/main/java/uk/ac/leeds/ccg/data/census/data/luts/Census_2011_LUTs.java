/*
 * Copyright 2019 Centre for Computational Geography, University of Leeds.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.ac.leeds.ccg.data.census.data.luts;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import uk.ac.leeds.ccg.data.core.Data_Environment;
import uk.ac.leeds.ccg.data.format.Data_ReadTXT;
import uk.ac.leeds.ccg.generic.core.Generic_Environment;
import uk.ac.leeds.ccg.data.census.core.Census_Environment;
import uk.ac.leeds.ccg.data.census.core.Census_Object;
import uk.ac.leeds.ccg.data.census.core.Census_Strings;
import uk.ac.leeds.ccg.data.census.data.id.Census_2011_LADID;
import uk.ac.leeds.ccg.data.census.data.id.Census_2011_LSOAID;
import uk.ac.leeds.ccg.data.census.data.id.Census_2011_OAID;
import uk.ac.leeds.ccg.data.census.data.id.Census_MSOAID;
import uk.ac.leeds.ccg.generic.io.Generic_Defaults;
import uk.ac.leeds.ccg.generic.io.Generic_IO;
import uk.ac.leeds.ccg.generic.util.Generic_Collections;

/**
 * For Census look ups to/from 2011 Output Areas (OAs). OAs aggregate into Lower
 * Layer Super Output Areas (LSOAs) which aggregate onto Middle Layer Super
 * Output Areas (MSOAs). MSOAs for the 2011 Census are supposed to be the same
 * for the 2011 Census.
 *
 * @author Andy Turner
 * @version 1.0.0.
 */
public class Census_2011_LUTs extends Census_Object {

    /**
     * For storing a list of all OA IDs.
     */
    public HashSet<Census_2011_OAID> OAIDs;

    /**
     * For storing a list of all Lower Layer Super Output Area IDs.
     */
    public HashSet<Census_2011_LSOAID> LSOAIDs;

    /**
     * For storing a list of all Middle Layer Super Output Area IDs.
     */
    public HashSet<Census_MSOAID> MSOAIDs;

    /**
     * For storing a list of all 2011 Local Authority District IDs.
     */
    public HashSet<Census_2011_LADID> LADIDs;

    /**
     * For storing a lookup from an OA code to an OAID.
     */
    public HashMap<String, Census_2011_OAID> OA2OAID;

    /**
     * For storing a lookup from an OAID to an OA code.
     */
    public HashMap<Census_2011_OAID, String> OAID2OA;

    /**
     * For storing a lookup from an LSOA code to an LSOAID.
     */
    public HashMap<String, Census_2011_LSOAID> LSOA2LSOAID;

    /**
     * For storing a lookup from an LSOAID to an LSOA code.
     */
    public HashMap<Census_2011_LSOAID, String> LSOAID2LSOA;

    /**
     * For storing a lookup from an MSOA code to an MSOAID.
     */
    public HashMap<String, Census_MSOAID> MSOA2MSOAID;

    /**
     * For storing a lookup from an MSOAID to an MSOA code.
     */
    public HashMap<Census_MSOAID, String> MSOAID2MSOA;

    /**
     * For storing a lookup from an LAD code to an LADID.
     */
    public HashMap<String, Census_2011_LADID> LAD2LADID;

    /**
     * For storing a lookup from an LADID to an LAD code.
     */
    public HashMap<Census_2011_LADID, String> LADID2LAD;

    /**
     * For storing a lookup from an LAD name to an LADID.
     */
    public HashMap<String, Census_2011_LADID> LADNAME2LADID;

    /**
     * For storing a lookup from an LADID to an LAD name.
     */
    public HashMap<Census_2011_LADID, String> LADID2LADNAME;

    /**
     * For a lookup from an OAID to a LSOAID
     */
    public HashMap<Census_2011_OAID, Census_2011_LSOAID> OAID2LSOAID;

    /**
     * For a lookup from an LSOAID to a set of OAIDs
     */
    public HashMap<Census_2011_LSOAID, Set<Census_2011_OAID>> LSOAID2OAIDs;

    /**
     * For a lookup from an OAID to a MSOAID
     */
    public HashMap<Census_2011_OAID, Census_MSOAID> OAID2MSOAID;

    /**
     * For a lookup from an MSOAID to a set of OAIDs
     */
    public HashMap<Census_MSOAID, Set<Census_2011_OAID>> MSOAID2OAIDs;

    /**
     * For a lookup from an OAID to a LADID
     */
    public HashMap<Census_2011_OAID, Census_2011_LADID> OAID2LADID;

    /**
     * For a lookup from an LADID to a set of OAIDs
     */
    public HashMap<Census_2011_LADID, Set<Census_2011_OAID>> LADID2OAIDs;

    /**
     * For a lookup from an LSOAID to a MSOAID
     */
    public HashMap<Census_2011_LSOAID, Census_MSOAID> LSOAID2MSOAID;

    /**
     * For a lookup from an MSOAID to a set of LSOAIDs
     */
    public HashMap<Census_MSOAID, Set<Census_2011_LSOAID>> MSOAID2LSOAIDs;

    /**
     * For a lookup from an LADID to a set of LSOAIDs
     */
    public HashMap<Census_2011_LADID, Set<Census_2011_LSOAID>> LADID2LSOAIDs;

    /**
     * For a lookup from an LSOAID to a set of LSOAIDs
     */
    public HashMap<Census_2011_LSOAID, Census_2011_LADID> LSOAID2LADID;

    /**
     * For a lookup from an LADID to a set of MSOAIDs
     */
    public HashMap<Census_2011_LADID, Set<Census_MSOAID>> LADID2MSOAIDs;

    /**
     * For a lookup from an LSOAID to a set of LSOAIDs
     */
    public HashMap<Census_MSOAID, Census_2011_LADID> MSOAID2LADID;

    public Census_2011_LUTs(Census_Environment e) throws FileNotFoundException, IOException {
        super(e);
        // Initialise collections.
        // ID sets
        OAIDs = new HashSet<>();
        LSOAIDs = new HashSet<>();
        MSOAIDs = new HashSet<>();
        LADIDs = new HashSet<>();
        // ID lookups
        OA2OAID = new HashMap<>();
        OAID2OA = new HashMap<>();
        LSOA2LSOAID = new HashMap<>();
        LSOAID2LSOA = new HashMap<>();
        MSOA2MSOAID = new HashMap<>();
        MSOAID2MSOA = new HashMap<>();
        LAD2LADID = new HashMap<>();
        LADID2LAD = new HashMap<>();
        LADNAME2LADID = new HashMap<>();
        LADID2LADNAME = new HashMap<>();
        // Lookups
        OAID2LSOAID = new HashMap<>();
        LSOAID2OAIDs = new HashMap<>();
        OAID2MSOAID = new HashMap<>();
        MSOAID2OAIDs = new HashMap<>();
        OAID2LADID = new HashMap<>();
        LADID2OAIDs = new HashMap<>();
        LSOAID2MSOAID = new HashMap<>();
        MSOAID2LSOAIDs = new HashMap<>();
        LADID2LSOAIDs = new HashMap<>();
        LSOAID2LADID = new HashMap<>();
        LADID2MSOAIDs = new HashMap<>();
        MSOAID2LADID = new HashMap<>();

        // Common things for loading from the files.
        String fn;
        Path f;
        Data_ReadTXT reader = new Data_ReadTXT(env.de);
        String line;

        /**
         * Initialise LUTs between OA, LSOA and MSOA.
         */
        fn = "Output_Area_to_Lower_Layer_Super_Output_Area_to_Middle_Layer_"
                + "Super_Output_Area_to_Local_Authority_District_December_"
                + "2011_Lookup_in_England_and_Wales.csv";
        f = Paths.get(env.files.getInput2011LUTDir().toString(), fn);
        try (BufferedReader br = Generic_IO.getBufferedReader(f)) {
            StreamTokenizer st = new StreamTokenizer(br);
            Generic_IO.setStreamTokenizerSyntax1(st);
            Generic_IO.setStreamTokenizerSyntaxNumbersAsWords1(st);
            line = reader.readLine();       // Skip header...
            env.de.env.log("Reading " + f); // ...
            env.de.env.log(line);           // ... but log it.
            while (line != null) {
                //env.de.env.log(line); // For testing.
                String[] split = line.split(",");
                // Add to OAIDs, OA2OAID and OAID2OA
                Census_2011_OAID oaid = new Census_2011_OAID(OAIDs.size());
                OAIDs.add(oaid);
                OA2OAID.put(split[0], oaid);
                OAID2OA.put(oaid, split[0]);
                // Add to LSOAIDs, LSOA2LSOAID and LSOAID2LSOA
                Census_2011_LSOAID lsoaid;
                if (LSOA2LSOAID.containsKey(split[1])) {
                    lsoaid = LSOA2LSOAID.get(split[1]);
                } else {
                    lsoaid = new Census_2011_LSOAID(LSOAIDs.size());
                    LSOAIDs.add(lsoaid);
                    LSOA2LSOAID.put(split[1], lsoaid);
                    LSOAID2LSOA.put(lsoaid, split[1]);
                    // Add to OAID2LSOAID and LSOAID2OAIDs
                    OAID2LSOAID.put(oaid, lsoaid);
                    Generic_Collections.addToMap(LSOAID2OAIDs, lsoaid, oaid);
                }
                // Add to MSOAIDs, MSOA2MSOAID and MSOAID2MSOA                
                Census_MSOAID msoaid;
                if (MSOA2MSOAID.containsKey(split[3])) {
                    msoaid = MSOA2MSOAID.get(split[3]);
                } else {
                    msoaid = new Census_MSOAID(MSOAIDs.size());
                    MSOAIDs.add(msoaid);
                    MSOA2MSOAID.put(split[3], msoaid);
                    MSOAID2MSOA.put(msoaid, split[3]);
                    // Add to OAID2MSOAID and MSOAID2OAIDs
                    OAID2MSOAID.put(oaid, msoaid);
                    Generic_Collections.addToMap(MSOAID2OAIDs, msoaid, oaid);
                }
                // Add to LADIDs, LAD2LADID and LADID2LAD, and LADNAME2LADID and LADID2LADNAME                
                Census_2011_LADID ladid;
                if (LAD2LADID.containsKey(split[5])) {
                    ladid = LAD2LADID.get(split[5]);
                } else {
                    ladid = new Census_2011_LADID(LADIDs.size());
                    LADIDs.add(ladid);
                    LAD2LADID.put(split[5], ladid);
                    LADID2LAD.put(ladid, split[5]);
                    LADNAME2LADID.put(split[6], ladid);
                    LADID2LADNAME.put(ladid, split[6]);
                }
                // Add to OAID2LADID and LADID2OAIDs
                OAID2LADID.put(oaid, ladid);
                Generic_Collections.addToMap(LADID2OAIDs, ladid, oaid);
                // Add to LSOAID2MSOAID and MSOAID2LSOAIDs
                LSOAID2MSOAID.put(lsoaid, msoaid);
                Generic_Collections.addToMap(MSOAID2LSOAIDs, msoaid, lsoaid);
                // Add to LSOAID2LADID and LADID2LSOAIDs 
                LSOAID2LADID.put(lsoaid, ladid);
                Generic_Collections.addToMap(LADID2LSOAIDs, ladid, lsoaid);
                // Add to MSOAID2LADID and LADID2MSOAIDs 
                MSOAID2LADID.put(msoaid, ladid);
                Generic_Collections.addToMap(LADID2MSOAIDs, ladid, msoaid);
                // Get next line.
                line = reader.readLine();
            }
        }
    }

    public static void main(String[] args) {
        try {
            Data_Environment de = new Data_Environment(new Generic_Environment(
                    new Generic_Defaults()));
            Path dataDir = Paths.get(de.files.getDataDir().toString(),
                    Census_Strings.s_census);
            Census_Environment e = new Census_Environment(de, dataDir);
            Census_2011_LUTs p = new Census_2011_LUTs(e);
            // Log sizes of sets of IDs.
            p.env.de.env.log("OAIDs.size()=" + p.OAIDs.size());
            p.env.de.env.log("LSOAIDs.size()=" + p.LSOAIDs.size());
            p.env.de.env.log("MSOAIDs.size()=" + p.MSOAIDs.size());
            p.env.de.env.log("LADIDs.size()=" + p.LADIDs.size());
            // Log names of all LADs.
            p.LADNAME2LADID.keySet().stream().forEach(i -> p.env.de.env.log(i));
            // Get all OAIDs in Leeds
            String area = Census_Strings.s_Leeds;
            Census_2011_LADID ladid = p.LADNAME2LADID.get(area);
            Set<Census_2011_OAID> oas = p.LADID2OAIDs.get(ladid);
            p.env.de.env.log("There are " + oas.size() + " output areas in "
                    + area + " Local Authority District.");
            Iterator<Census_2011_OAID> oasite = oas.iterator();
            while (oasite.hasNext()) {
                String oa = p.OAID2OA.get(oasite.next());
                p.env.de.env.log(oa);
            }
            //p.env.de.env.log("LADIDs.size()=" + p.LSOAID2LSOA.get(p.LSOAIDs.get());

        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }
    //getCensusCodes(area, level, censusDataDirectory);
}
