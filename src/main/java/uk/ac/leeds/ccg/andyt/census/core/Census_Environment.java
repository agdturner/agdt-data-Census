/*
 * Copyright (C) 2014 geoagdt.
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
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package uk.ac.leeds.ccg.andyt.census.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.TreeSet;
import uk.ac.leeds.ccg.andyt.generic.core.Generic_Environment;

/**
 *
 * @author geoagdt
 */
public class Census_Environment extends Generic_Environment {

    /**
     * @param area
     * @param level "OA" or "LSOA" or "MSOA" currently...
     * @return <code>TreeSet&ltString&gt</code> of LSOA codes for the Leeds
     * Local Authority District loaded from a specific file within
     * digitalWelfareDir.
     */
    public TreeSet<String> getCensusCodes(
            String area,
            String level,
            File censusDataDirectory) {
        TreeSet<String> result = null;
        File file = new File(censusDataDirectory,
                "censusCodes.csv");
        if (file.exists()) {
            try {
                BufferedReader br;
                StreamTokenizer st;
                br = io.getBufferedReader(file);
                if (br != null) {
                    result = new TreeSet<String>();
                    st = new StreamTokenizer(br);
                    io.setStreamTokenizerSyntax1(st);
                    int token = st.nextToken();
//                    long RecordID = 0;
                    String line = "";
                    while (!(token == StreamTokenizer.TT_EOF)) {
                        switch (token) {
                            case StreamTokenizer.TT_EOL:
//                                if (RecordID % 100 == 0) {
//                                    System.out.println(line);
//                                }
//                                RecordID++;
                                break;
                            case StreamTokenizer.TT_WORD:
                                line = st.sval;
                                result.add(line);
                                break;
                        }
                        token = st.nextToken();
                    }
                    br.close();
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        return result;
    }

}
