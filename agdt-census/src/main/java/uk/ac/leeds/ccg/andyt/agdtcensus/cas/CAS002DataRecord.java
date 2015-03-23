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

import java.io.IOException;
import java.io.RandomAccessFile;
import uk.ac.leeds.ccg.andyt.generic.core.Generic_ErrorAndExceptionHandler;
import uk.ac.leeds.ccg.andyt.generic.math.StaticConverter;

/**
 * A <code>class</code> for representing a CAS002 Data Record and providing safe
 * access to the data.
 * <ul>
 * <li>Developed for <a href="http://www.ncess.ac.uk/moses">MoSeS</a>.</li>
 * <li>Copyright (C) 2006 <a
 * href="http://www.geog.leeds.ac.uk/people/a.turner/">Andy Turner</a>, <a
 * href="http://www.leeds.ac.uk//">University of Leeds</a>.</li>
 * </ul>
 * 
 * @author <a href="http://www.geog.leeds.ac.uk/people/a.turner/">Andy
 *         Turner</a>
 * @version 1.0.0, 2006-08-10
 * @see CAS002DataHandler
 */
public class CAS002DataRecord extends AbstractCASDataRecord {

    /*
     * Table CS002 Age by Sex and Marital Status: All People Footnotes and
     * Comments for Table CS002 1 ONS have confirmed that table CS002 should
     * contain separate categories of 65-69 and 70-74 years of age instead of
     * the combined 65-74 category that is actually present. This error was due
     * to a fault in the production of the table. The data available for this
     * category does fit the description within the table framework (i.e. it is
     * genuinely for a category of 65-74 years of age).
     */
    /**
     * CS0020001 = allPeople
     */
    protected int allPeopleTotal;
    /**
     * CS0020002 = allPeopleMarried
     */
    protected int allPeopleMarried;
    /**
     * CS0020003 = allPeopleSingle
     */
    protected int allPeopleSingle;
    /**
     * CS0020004 = malesTotal
     */
    protected int malesTotal;
    /**
     * CS0020005 = malesMarried
     */
    protected int malesMarried;
    /**
     * CS0020006 = malesSingle
     */
    protected int malesSingle;
    /**
     * CS0020007 = femalesTotal
     */
    protected int femalesTotal;
    /**
     * CS0020008 = femalesMarried
     */
    protected int femalesMarried;
    /**
     * CS0020009 = femalesSingle
     */
    protected int femalesSingle;
    /**
     * CS0020010 = allPeopleAge0to15
     */
    protected int allPeopleTotalAge0to15;
    /**
     * CS0020011 = allPeopleMarriedAge0to15
     */
    protected int allPeopleMarriedAge0to15;
    /**
     * CS0020012 = allPeopleSingleAge0to15
     */
    protected int allPeopleSingleAge0to15;
    /**
     * CS0020013 = malesTotalAge0to15
     */
    protected int malesTotalAge0to15;
    /**
     * CS0020014 = malesMarriedAge0to15
     */
    protected int malesMarriedAge0to15;
    /**
     * CS0020015 = malesSingleAge0to15
     */
    protected int malesSingleAge0to15;
    /**
     * CS0020016 = femalesTotalAge0to15
     */
    protected int femalesTotalAge0to15;
    /**
     * CS0020017 = femalesMarriedAge0to15
     */
    protected int femalesMarriedAge0to15;
    /**
     * CS0020018 = femalesSingleAge0to15
     */
    protected int femalesSingleAge0to15;
    /**
     * CS0020019 = allPeopleAge16to19
     */
    protected int allPeopleTotalAge16to19;
    /**
     * CS0020020 = allPeopleMarriedAge16to19
     */
    protected int allPeopleMarriedAge16to19;
    /**
     * CS0020021 = allPeopleSingleAge16to19
     */
    protected int allPeopleSingleAge16to19;
    /**
     * CS0020022 = malesTotalAge16to19
     */
    protected int malesTotalAge16to19;
    /**
     * CS0020023 = malesMarriedAge16to19
     */
    protected int malesMarriedAge16to19;
    /**
     * CS0020024 = malesSingleAge16to19
     */
    protected int malesSingleAge16to19;
    /**
     * CS0020025 = femalesTotalAge16to19
     */
    protected int femalesTotalAge16to19;
    /**
     * CS0020026 = femalesMarriedAge16to19
     */
    protected int femalesMarriedAge16to19;
    /**
     * CS0020027 = femalesSingleAge16to19
     */
    protected int femalesSingleAge16to19;
    /**
     * CS0020028 = allPeopleAge20to24
     */
    protected int allPeopleTotalAge20to24;
    /**
     * CS0020029 = allPeopleMarriedAge20to24
     */
    protected int allPeopleMarriedAge20to24;
    /**
     * CS0020030 = allPeopleSingleAge20to24
     */
    protected int allPeopleSingleAge20to24;
    /**
     * CS0020031 = malesTotalAge20to24
     */
    protected int malesTotalAge20to24;
    /**
     * CS0020032 = malesMarriedAge20to24
     */
    protected int malesMarriedAge20to24;
    /**
     * CS0020033 = malesSingleAge20to24
     */
    protected int malesSingleAge20to24;
    /**
     * CS0020034 = femalesTotalAge20to24
     */
    protected int femalesTotalAge20to24;
    /**
     * CS0020035 = femalesMarriedAge20to24
     */
    protected int femalesMarriedAge20to24;
    /**
     * CS0020036 = femalesSingleAge20to24
     */
    protected int femalesSingleAge20to24;
    /**
     * CS0020037 = allPeopleAge25to29
     */
    protected int allPeopleTotalAge25to29;
    /**
     * CS0020038 = allPeopleMarriedAge25to29
     */
    protected int allPeopleMarriedAge25to29;
    /**
     * CS0020039 = allPeopleSingleAge25to29
     */
    protected int allPeopleSingleAge25to29;
    /**
     * CS0020040 = malesTotalAge25to29
     */
    protected int malesTotalAge25to29;
    /**
     * CS0020041 = malesMarriedAge25to29
     */
    protected int malesMarriedAge25to29;
    /**
     * CS0020042 = malesSingleAge25to29
     */
    protected int malesSingleAge25to29;
    /**
     * CS0020043 = femalesTotalAge25to29
     */
    protected int femalesTotalAge25to29;
    /**
     * CS0020044 = femalesMarriedAge25to29
     */
    protected int femalesMarriedAge25to29;
    /**
     * CS0020045 = femalesSingleAge25to29
     */
    protected int femalesSingleAge25to29;
    /**
     * CS0020046 = allPeopleAge30to34
     */
    protected int allPeopleTotalAge30to34;
    /**
     * CS0020047 = allPeopleMarriedAge30to34
     */
    protected int allPeopleMarriedAge30to34;
    /**
     * CS0020048 = allPeopleSingleAge30to34
     */
    protected int allPeopleSingleAge30to34;
    /**
     * CS0020049 = malesTotalAge30to34
     */
    protected int malesTotalAge30to34;
    /**
     * CS0020050 = malesMarriedAge30to34
     */
    protected int malesMarriedAge30to34;
    /**
     * CS0020051 = malesSingleAge30to34
     */
    protected int malesSingleAge30to34;
    /**
     * CS0020052 = femalesTotalAge30to34
     */
    protected int femalesTotalAge30to34;
    /**
     * CS0020053 = femalesMarriedAge30to34
     */
    protected int femalesMarriedAge30to34;
    /**
     * CS0020054 = femalesSingleAge30to34
     */
    protected int femalesSingleAge30to34;
    /**
     * CS0020055 = allPeopleAge35to39
     */
    protected int allPeopleTotalAge35to39;
    /**
     * CS0020056 = allPeopleMarriedAge35to39
     */
    protected int allPeopleMarriedAge35to39;
    /**
     * CS0020057 = allPeopleSingleAge35to39
     */
    protected int allPeopleSingleAge35to39;
    /**
     * CS0020058 = malesTotalAge35to39
     */
    protected int malesTotalAge35to39;
    /**
     * CS0020059 = malesMarriedAge35to39
     */
    protected int malesMarriedAge35to39;
    /**
     * CS0020060 = malesSingleAge35to39
     */
    protected int malesSingleAge35to39;
    /**
     * CS0020061 = femalesTotalAge35to39
     */
    protected int femalesTotalAge35to39;
    /**
     * CS0020062 = femalesMarriedAge35to39
     */
    protected int femalesMarriedAge35to39;
    /**
     * CS0020063 = femalesSingleAge35to39
     */
    protected int femalesSingleAge35to39;
    /**
     * CS0020064 = allPeopleAge40to44
     */
    protected int allPeopleTotalAge40to44;
    /**
     * CS0020065 = allPeopleMarriedAge40to44
     */
    protected int allPeopleMarriedAge40to44;
    /**
     * CS0020066 = allPeopleSingleAge40to44
     */
    protected int allPeopleSingleAge40to44;
    /**
     * CS0020067 = malesTotalAge40to44
     */
    protected int malesTotalAge40to44;
    /**
     * CS0020068 = malesMarriedAge40to44
     */
    protected int malesMarriedAge40to44;
    /**
     * CS0020069 = malesSingleAge40to44
     */
    protected int malesSingleAge40to44;
    /**
     * CS0020070 = femalesTotalAge40to44
     */
    protected int femalesTotalAge40to44;
    /**
     * CS0020071 = femalesMarriedAge40to44
     */
    protected int femalesMarriedAge40to44;
    /**
     * CS0020072 = femalesSingleAge40to44
     */
    protected int femalesSingleAge40to44;
    /**
     * CS0020073 = allPeopleAge45to49
     */
    protected int allPeopleTotalAge45to49;
    /**
     * CS0020074 = allPeopleMarriedAge45to49
     */
    protected int allPeopleMarriedAge45to49;
    /**
     * CS0020075 = allPeopleSingleAge45to49
     */
    protected int allPeopleSingleAge45to49;
    /**
     * CS0020076 = malesTotalAge45to49
     */
    protected int malesTotalAge45to49;
    /**
     * CS0020077 = malesMarriedAge45to49
     */
    protected int malesMarriedAge45to49;
    /**
     * CS0020078 = malesSingleAge45to49
     */
    protected int malesSingleAge45to49;
    /**
     * CS0020079 = femalesTotalAge45to49
     */
    protected int femalesTotalAge45to49;
    /**
     * CS0020080 = femalesMarriedAge45to49
     */
    protected int femalesMarriedAge45to49;
    /**
     * CS0020081 = femalesSingleAge45to49
     */
    protected int femalesSingleAge45to49;
    /**
     * CS0020082 = allPeopleAge50to54
     */
    protected int allPeopleTotalAge50to54;
    /**
     * CS0020083 = allPeopleMarriedAge50to54
     */
    protected int allPeopleMarriedAge50to54;
    /**
     * CS0020084 = allPeopleSingleAge50to54
     */
    protected int allPeopleSingleAge50to54;
    /**
     * CS0020085 = malesTotalAge50to54
     */
    protected int malesTotalAge50to54;
    /**
     * CS0020086 = malesMarriedAge50to54
     */
    protected int malesMarriedAge50to54;
    /**
     * CS0020087 = malesSingleAge50to54
     */
    protected int malesSingleAge50to54;
    /**
     * CS0020088 = femalesTotalAge50to54
     */
    protected int femalesTotalAge50to54;
    /**
     * CS0020089 = femalesMarriedAge50to54
     */
    protected int femalesMarriedAge50to54;
    /**
     * CS0020090 = femalesSingleAge50to54
     */
    protected int femalesSingleAge50to54;
    /**
     * CS0020091 = allPeopleAge55to59
     */
    protected int allPeopleTotalAge55to59;
    /**
     * CS0020092 = allPeopleMarriedAge55to59
     */
    protected int allPeopleMarriedAge55to59;
    /**
     * CS0020093 = allPeopleSingleAge55to59
     */
    protected int allPeopleSingleAge55to59;
    /**
     * CS0020094 = malesTotalAge55to59
     */
    protected int malesTotalAge55to59;
    /**
     * CS0020095 = malesMarriedAge55to59
     */
    protected int malesMarriedAge55to59;
    /**
     * CS0020096 = malesSingleAge55to59
     */
    protected int malesSingleAge55to59;
    /**
     * CS0020097 = femalesTotalAge55to59
     */
    protected int femalesTotalAge55to59;
    /**
     * CS0020098 = femalesMarriedAge55to59
     */
    protected int femalesMarriedAge55to59;
    /**
     * CS0020099 = femalesSingleAge55to59
     */
    protected int femalesSingleAge55to59;
    /**
     * CS0020100 = allPeopleAge60to64
     */
    protected int allPeopleTotalAge60to64;
    /**
     * CS0020101 = allPeopleMarriedAge60to64
     */
    protected int allPeopleMarriedAge60to64;
    /**
     * CS0020102 = allPeopleSingleAge60to64
     */
    protected int allPeopleSingleAge60to64;
    /**
     * CS0020103 = malesTotalAge60to64
     */
    protected int malesTotalAge60to64;
    /**
     * CS0020104 = malesMarriedAge60to64
     */
    protected int malesMarriedAge60to64;
    /**
     * CS0020105 = malesSingleAge60to64
     */
    protected int malesSingleAge60to64;
    /**
     * CS0020106 = femalesTotalAge60to64
     */
    protected int femalesTotalAge60to64;
    /**
     * CS0020107 = femalesMarriedAge60to64
     */
    protected int femalesMarriedAge60to64;
    /**
     * CS0020108 = femalesSingleAge60to64
     */
    protected int femalesSingleAge60to64;
    /**
     * CS0020109 = allPeopleAge65to74
     */
    protected int allPeopleTotalAge65to74;
    /**
     * CS0020110 = allPeopleMarriedAge65to74
     */
    protected int allPeopleMarriedAge65to74;
    /**
     * CS0020111 = allPeopleSingleAge65to74
     */
    protected int allPeopleSingleAge65to74;
    /**
     * CS0020112 = malesTotalAge65to74
     */
    protected int malesTotalAge65to74;
    /**
     * CS0020113 = malesMarriedAge65to74
     */
    protected int malesMarriedAge65to74;
    /**
     * CS0020114 = malesSingleAge65to74
     */
    protected int malesSingleAge65to74;
    /**
     * CS0020115 = femalesTotalAge65to74
     */
    protected int femalesTotalAge65to74;
    /**
     * CS0020116 = femalesMarriedAge65to74
     */
    protected int femalesMarriedAge65to74;
    /**
     * CS0020117 = femalesSingleAge65to74
     */
    protected int femalesSingleAge65to74;
    /**
     * CS0020118 = allPeopleAge75to79
     */
    protected int allPeopleTotalAge75to79;
    /**
     * CS0020119 = allPeopleMarriedAge75to79
     */
    protected int allPeopleMarriedAge75to79;
    /**
     * CS0020120 = allPeopleSingleAge75to79
     */
    protected int allPeopleSingleAge75to79;
    /**
     * CS0020121 = malesTotalAge75to79
     */
    protected int malesTotalAge75to79;
    /**
     * CS0020122 = malesMarriedAge75to79
     */
    protected int malesMarriedAge75to79;
    /**
     * CS0020123 = malesSingleAge75to79
     */
    protected int malesSingleAge75to79;
    /**
     * CS0020124 = femalesTotalAge75to79
     */
    protected int femalesTotalAge75to79;
    /**
     * CS0020125 = femalesMarriedAge75to79
     */
    protected int femalesMarriedAge75to79;
    /**
     * CS0020126 = femalesSingleAge75to79
     */
    protected int femalesSingleAge75to79;
    /**
     * CS0020127 = allPeopleAge80to84
     */
    protected int allPeopleTotalAge80to84;
    /**
     * CS0020128 = allPeopleMarriedAge80to84
     */
    protected int allPeopleMarriedAge80to84;
    /**
     * CS0020129 = allPeopleSingleAge80to84
     */
    protected int allPeopleSingleAge80to84;
    /**
     * CS0020130 = malesTotalAge80to84
     */
    protected int malesTotalAge80to84;
    /**
     * CS0020131 = malesMarriedAge80to84
     */
    protected int malesMarriedAge80to84;
    /**
     * CS0020132 = malesSingleAge80to84
     */
    protected int malesSingleAge80to84;
    /**
     * CS0020133 = femalesTotalAge80to84
     */
    protected int femalesTotalAge80to84;
    /**
     * CS0020134 = femalesMarriedAge80to84
     */
    protected int femalesMarriedAge80to84;
    /**
     * CS0020135 = femalesSingleAge80to84
     */
    protected int femalesSingleAge80to84;
    /**
     * CS0020136 = allPeopleAge85to89
     */
    protected int allPeopleTotalAge85to89;
    /**
     * CS0020137 = allPeopleMarriedAge85to89
     */
    protected int allPeopleMarriedAge85to89;
    /**
     * CS0020138 = allPeopleSingleAge85to89
     */
    protected int allPeopleSingleAge85to89;
    /**
     * CS0020139 = malesTotalAge85to89
     */
    protected int malesTotalAge85to89;
    /**
     * CS0020140 = malesMarriedAge85to89
     */
    protected int malesMarriedAge85to89;
    /**
     * CS0020141 = malesSingleAge85to89
     */
    protected int malesSingleAge85to89;
    /**
     * CS0020142 = femalesTotalAge85to89
     */
    protected int femalesTotalAge85to89;
    /**
     * CS0020143 = femalesMarriedAge85to89
     */
    protected int femalesMarriedAge85to89;
    /**
     * CS0020144 = femalesSingleAge85to89
     */
    protected int femalesSingleAge85to89;
    /**
     * CS0020145 = allPeopleAge90AndOver
     */
    protected int allPeopleTotalAge90AndOver;
    /**
     * CS0020146 = allPeopleMarriedAge90AndOver
     */
    protected int allPeopleMarriedAge90AndOver;
    /**
     * CS0020147 = allPeopleSingleAge90AndOver
     */
    protected int allPeopleSingleAge90AndOver;
    /**
     * CS0020148 = malesTotalAge90AndOver
     */
    protected int malesTotalAge90AndOver;
    /**
     * CS0020149 = malesMarriedAge90AndOver
     */
    protected int malesMarriedAge90AndOver;
    /**
     * CS0020150 = malesSingleAge90AndOver
     */
    protected int malesSingleAge90AndOver;
    /**
     * CS0020151 = femalesTotalAge90AndOver
     */
    protected int femalesTotalAge90AndOver;
    /**
     * CS0020152 = femalesMarriedAge90AndOver
     */
    protected int femalesMarriedAge90AndOver;
    /**
     * CS0020153 = femalesSingleAge90AndOver
     */
    protected int femalesSingleAge90AndOver;

    /** Creates a new CAS002DataRecord */
    public CAS002DataRecord() {
        _Init();
    }

    /**
     * Creates a new CAS002DataRecord cloned from aCAS002DataRecord
     *
     * @param aCAS002DataRecord
     *            The CAS002DataRecord from which this is cloned.
     */
    public CAS002DataRecord(CAS002DataRecord aCAS002DataRecord) {
        init(aCAS002DataRecord);
    }

    /**
     * Creates a new CAS002DataRecord
     *
     * @param initZero
     *            To ensure initZero() is used instead of _Init()
     */
    public CAS002DataRecord(boolean initZero) {
        initZero();
    }

    /**
     * Creates a new CAS002DataRecord
     *
     * @param RecordID
     *            The RecordID to be assigned to this
     * @param line
     *            The Comma Seperated Value <code>String</code>
     * @throws java.io.IOException
     */
    public CAS002DataRecord(
            long RecordID,
            String line)
            throws IOException {
        String[] fields = line.split(",");
        // String[] fieldsDummy = line.split( "," );
        // // System.out.println(fieldsDummy.length);
        // // for (int i = 0; i < fieldsDummy.length; i ++ ){
        // // System.out.println(fieldsDummy[i]);
        // // }
        // String[] fields = new String[ 154 ];
        // for ( int i = 0; i < fields.length; i ++ ) {
        // fields[ i ] = "";
        // }
        // System.arraycopy( fieldsDummy, 0, fields, 0, fields.length );
        this._RecordID = RecordID;
        this.Zone_Code = fields[0].substring(1, 11).toCharArray();
        // From Table CAS002
        this.allPeopleTotal = StaticConverter.to_int(fields[1]);
        this.allPeopleMarried = StaticConverter.to_int(fields[2]);
        this.allPeopleSingle = StaticConverter.to_int(fields[3]);
        this.malesTotal = StaticConverter.to_int(fields[4]);
        this.malesMarried = StaticConverter.to_int(fields[5]);
        this.malesSingle = StaticConverter.to_int(fields[6]);
        this.femalesTotal = StaticConverter.to_int(fields[7]);
        this.femalesMarried = StaticConverter.to_int(fields[8]);
        this.femalesSingle = StaticConverter.to_int(fields[9]);
        this.allPeopleTotalAge0to15 = StaticConverter.to_int(fields[10]);
        this.allPeopleMarriedAge0to15 = StaticConverter.to_int(fields[11]);
        this.allPeopleSingleAge0to15 = StaticConverter.to_int(fields[12]);
        this.malesTotalAge0to15 = StaticConverter.to_int(fields[13]);
        this.malesMarriedAge0to15 = StaticConverter.to_int(fields[14]);
        this.malesSingleAge0to15 = StaticConverter.to_int(fields[15]);
        this.femalesTotalAge0to15 = StaticConverter.to_int(fields[16]);
        this.femalesMarriedAge0to15 = StaticConverter.to_int(fields[17]);
        this.femalesSingleAge0to15 = StaticConverter.to_int(fields[18]);
        this.allPeopleTotalAge16to19 = StaticConverter.to_int(fields[19]);
        this.allPeopleMarriedAge16to19 = StaticConverter.to_int(fields[20]);
        this.allPeopleSingleAge16to19 = StaticConverter.to_int(fields[21]);
        this.malesTotalAge16to19 = StaticConverter.to_int(fields[22]);
        this.malesMarriedAge16to19 = StaticConverter.to_int(fields[23]);
        this.malesSingleAge16to19 = StaticConverter.to_int(fields[24]);
        this.femalesTotalAge16to19 = StaticConverter.to_int(fields[25]);
        this.femalesMarriedAge16to19 = StaticConverter.to_int(fields[26]);
        this.femalesSingleAge16to19 = StaticConverter.to_int(fields[27]);
        this.allPeopleTotalAge20to24 = StaticConverter.to_int(fields[28]);
        this.allPeopleMarriedAge20to24 = StaticConverter.to_int(fields[29]);
        this.allPeopleSingleAge20to24 = StaticConverter.to_int(fields[30]);
        this.malesTotalAge20to24 = StaticConverter.to_int(fields[31]);
        this.malesMarriedAge20to24 = StaticConverter.to_int(fields[32]);
        this.malesSingleAge20to24 = StaticConverter.to_int(fields[33]);
        this.femalesTotalAge20to24 = StaticConverter.to_int(fields[34]);
        this.femalesMarriedAge20to24 = StaticConverter.to_int(fields[35]);
        this.femalesSingleAge20to24 = StaticConverter.to_int(fields[36]);
        this.allPeopleTotalAge25to29 = StaticConverter.to_int(fields[37]);
        this.allPeopleMarriedAge25to29 = StaticConverter.to_int(fields[38]);
        this.allPeopleSingleAge25to29 = StaticConverter.to_int(fields[39]);
        this.malesTotalAge25to29 = StaticConverter.to_int(fields[40]);
        this.malesMarriedAge25to29 = StaticConverter.to_int(fields[41]);
        this.malesSingleAge25to29 = StaticConverter.to_int(fields[42]);
        this.femalesTotalAge25to29 = StaticConverter.to_int(fields[43]);
        this.femalesMarriedAge25to29 = StaticConverter.to_int(fields[44]);
        this.femalesSingleAge25to29 = StaticConverter.to_int(fields[45]);
        this.allPeopleTotalAge30to34 = StaticConverter.to_int(fields[46]);
        this.allPeopleMarriedAge30to34 = StaticConverter.to_int(fields[47]);
        this.allPeopleSingleAge30to34 = StaticConverter.to_int(fields[48]);
        this.malesTotalAge30to34 = StaticConverter.to_int(fields[49]);
        this.malesMarriedAge30to34 = StaticConverter.to_int(fields[50]);
        this.malesSingleAge30to34 = StaticConverter.to_int(fields[51]);
        this.femalesTotalAge30to34 = StaticConverter.to_int(fields[52]);
        this.femalesMarriedAge30to34 = StaticConverter.to_int(fields[53]);
        this.femalesSingleAge30to34 = StaticConverter.to_int(fields[54]);
        this.allPeopleTotalAge35to39 = StaticConverter.to_int(fields[55]);
        this.allPeopleMarriedAge35to39 = StaticConverter.to_int(fields[56]);
        this.allPeopleSingleAge35to39 = StaticConverter.to_int(fields[57]);
        this.malesTotalAge35to39 = StaticConverter.to_int(fields[58]);
        this.malesMarriedAge35to39 = StaticConverter.to_int(fields[59]);
        this.malesSingleAge35to39 = StaticConverter.to_int(fields[60]);
        this.femalesTotalAge35to39 = StaticConverter.to_int(fields[61]);
        this.femalesMarriedAge35to39 = StaticConverter.to_int(fields[62]);
        this.femalesSingleAge35to39 = StaticConverter.to_int(fields[63]);
        this.allPeopleTotalAge40to44 = StaticConverter.to_int(fields[64]);
        this.allPeopleMarriedAge40to44 = StaticConverter.to_int(fields[65]);
        this.allPeopleSingleAge40to44 = StaticConverter.to_int(fields[66]);
        this.malesTotalAge40to44 = StaticConverter.to_int(fields[67]);
        this.malesMarriedAge40to44 = StaticConverter.to_int(fields[68]);
        this.malesSingleAge40to44 = StaticConverter.to_int(fields[69]);
        this.femalesTotalAge40to44 = StaticConverter.to_int(fields[70]);
        this.femalesMarriedAge40to44 = StaticConverter.to_int(fields[71]);
        this.femalesSingleAge40to44 = StaticConverter.to_int(fields[72]);
        this.allPeopleTotalAge45to49 = StaticConverter.to_int(fields[73]);
        this.allPeopleMarriedAge45to49 = StaticConverter.to_int(fields[74]);
        this.allPeopleSingleAge45to49 = StaticConverter.to_int(fields[75]);
        this.malesTotalAge45to49 = StaticConverter.to_int(fields[76]);
        this.malesMarriedAge45to49 = StaticConverter.to_int(fields[77]);
        this.malesSingleAge45to49 = StaticConverter.to_int(fields[78]);
        this.femalesTotalAge45to49 = StaticConverter.to_int(fields[79]);
        this.femalesMarriedAge45to49 = StaticConverter.to_int(fields[80]);
        this.femalesSingleAge45to49 = StaticConverter.to_int(fields[81]);
        this.allPeopleTotalAge50to54 = StaticConverter.to_int(fields[82]);
        this.allPeopleMarriedAge50to54 = StaticConverter.to_int(fields[83]);
        this.allPeopleSingleAge50to54 = StaticConverter.to_int(fields[84]);
        this.malesTotalAge50to54 = StaticConverter.to_int(fields[85]);
        this.malesMarriedAge50to54 = StaticConverter.to_int(fields[86]);
        this.malesSingleAge50to54 = StaticConverter.to_int(fields[87]);
        this.femalesTotalAge50to54 = StaticConverter.to_int(fields[88]);
        this.femalesMarriedAge50to54 = StaticConverter.to_int(fields[89]);
        this.femalesSingleAge50to54 = StaticConverter.to_int(fields[90]);
        this.allPeopleTotalAge55to59 = StaticConverter.to_int(fields[91]);
        this.allPeopleMarriedAge55to59 = StaticConverter.to_int(fields[92]);
        this.allPeopleSingleAge55to59 = StaticConverter.to_int(fields[93]);
        this.malesTotalAge55to59 = StaticConverter.to_int(fields[94]);
        this.malesMarriedAge55to59 = StaticConverter.to_int(fields[95]);
        this.malesSingleAge55to59 = StaticConverter.to_int(fields[96]);
        this.femalesTotalAge55to59 = StaticConverter.to_int(fields[97]);
        this.femalesMarriedAge55to59 = StaticConverter.to_int(fields[98]);
        this.femalesSingleAge55to59 = StaticConverter.to_int(fields[99]);
        this.allPeopleTotalAge60to64 = StaticConverter.to_int(fields[100]);
        this.allPeopleMarriedAge60to64 = StaticConverter.to_int(fields[101]);
        this.allPeopleSingleAge60to64 = StaticConverter.to_int(fields[102]);
        this.malesTotalAge60to64 = StaticConverter.to_int(fields[103]);
        this.malesMarriedAge60to64 = StaticConverter.to_int(fields[104]);
        this.malesSingleAge60to64 = StaticConverter.to_int(fields[105]);
        this.femalesTotalAge60to64 = StaticConverter.to_int(fields[106]);
        this.femalesMarriedAge60to64 = StaticConverter.to_int(fields[107]);
        this.femalesSingleAge60to64 = StaticConverter.to_int(fields[108]);
        this.allPeopleTotalAge65to74 = StaticConverter.to_int(fields[109]);
        this.allPeopleMarriedAge65to74 = StaticConverter.to_int(fields[110]);
        this.allPeopleSingleAge65to74 = StaticConverter.to_int(fields[111]);
        this.malesTotalAge65to74 = StaticConverter.to_int(fields[112]);
        this.malesMarriedAge65to74 = StaticConverter.to_int(fields[113]);
        this.malesSingleAge65to74 = StaticConverter.to_int(fields[114]);
        this.femalesTotalAge65to74 = StaticConverter.to_int(fields[115]);
        this.femalesMarriedAge65to74 = StaticConverter.to_int(fields[116]);
        this.femalesSingleAge65to74 = StaticConverter.to_int(fields[117]);
        this.allPeopleTotalAge75to79 = StaticConverter.to_int(fields[118]);
        this.allPeopleMarriedAge75to79 = StaticConverter.to_int(fields[119]);
        this.allPeopleSingleAge75to79 = StaticConverter.to_int(fields[120]);
        this.malesTotalAge75to79 = StaticConverter.to_int(fields[121]);
        this.malesMarriedAge75to79 = StaticConverter.to_int(fields[122]);
        this.malesSingleAge75to79 = StaticConverter.to_int(fields[123]);
        this.femalesTotalAge75to79 = StaticConverter.to_int(fields[124]);
        this.femalesMarriedAge75to79 = StaticConverter.to_int(fields[125]);
        this.femalesSingleAge75to79 = StaticConverter.to_int(fields[126]);
        this.allPeopleTotalAge80to84 = StaticConverter.to_int(fields[127]);
        this.allPeopleMarriedAge80to84 = StaticConverter.to_int(fields[128]);
        this.allPeopleSingleAge80to84 = StaticConverter.to_int(fields[129]);
        this.malesTotalAge80to84 = StaticConverter.to_int(fields[130]);
        this.malesMarriedAge80to84 = StaticConverter.to_int(fields[131]);
        this.malesSingleAge80to84 = StaticConverter.to_int(fields[132]);
        this.femalesTotalAge80to84 = StaticConverter.to_int(fields[133]);
        this.femalesMarriedAge80to84 = StaticConverter.to_int(fields[134]);
        this.femalesSingleAge80to84 = StaticConverter.to_int(fields[135]);
        this.allPeopleTotalAge85to89 = StaticConverter.to_int(fields[136]);
        this.allPeopleMarriedAge85to89 = StaticConverter.to_int(fields[137]);
        this.allPeopleSingleAge85to89 = StaticConverter.to_int(fields[138]);
        this.malesTotalAge85to89 = StaticConverter.to_int(fields[139]);
        this.malesMarriedAge85to89 = StaticConverter.to_int(fields[140]);
        this.malesSingleAge85to89 = StaticConverter.to_int(fields[141]);
        this.femalesTotalAge85to89 = StaticConverter.to_int(fields[142]);
        this.femalesMarriedAge85to89 = StaticConverter.to_int(fields[143]);
        this.femalesSingleAge85to89 = StaticConverter.to_int(fields[144]);
        this.allPeopleTotalAge90AndOver = StaticConverter.to_int(fields[145]);
        this.allPeopleMarriedAge90AndOver = StaticConverter.to_int(fields[146]);
        this.allPeopleSingleAge90AndOver = StaticConverter.to_int(fields[147]);
        this.malesTotalAge90AndOver = StaticConverter.to_int(fields[148]);
        this.malesMarriedAge90AndOver = StaticConverter.to_int(fields[149]);
        this.malesSingleAge90AndOver = StaticConverter.to_int(fields[150]);
        this.femalesTotalAge90AndOver = StaticConverter.to_int(fields[151]);
        this.femalesMarriedAge90AndOver = StaticConverter.to_int(fields[152]);
        this.femalesSingleAge90AndOver = StaticConverter.to_int(fields[153]);
    }

    /**
     * Creates a new <code>CAS002DataRecord</code> from
     * <code>aRandomAccessFile</code>. The
     * <code>aRandomAccessFile.getFilePointer()</code> changes only as the
     * <code>CAS002DataRecord</code> is read.
     *
     * @param aRandomAccessFile
     *            The <code>RandomAccessFile</code> from which this is created.
     * @throws java.io.IOException
     */
    public CAS002DataRecord(RandomAccessFile aRandomAccessFile)
            throws IOException {
        try {
            this._RecordID = aRandomAccessFile.readLong();
            this.Zone_Code = new char[10];
            for (int i = 0; i < this.Zone_Code.length; i++) {
                Zone_Code[i] = aRandomAccessFile.readChar();
            }
            this.allPeopleTotal = aRandomAccessFile.readInt();
            this.allPeopleMarried = aRandomAccessFile.readInt();
            this.allPeopleSingle = aRandomAccessFile.readInt();
            this.malesTotal = aRandomAccessFile.readInt();
            this.malesMarried = aRandomAccessFile.readInt();
            this.malesSingle = aRandomAccessFile.readInt();
            this.femalesTotal = aRandomAccessFile.readInt();
            this.femalesMarried = aRandomAccessFile.readInt();
            this.femalesSingle = aRandomAccessFile.readInt();
            this.allPeopleTotalAge0to15 = aRandomAccessFile.readInt();
            this.allPeopleMarriedAge0to15 = aRandomAccessFile.readInt();
            this.allPeopleSingleAge0to15 = aRandomAccessFile.readInt();
            this.malesTotalAge0to15 = aRandomAccessFile.readInt();
            this.malesMarriedAge0to15 = aRandomAccessFile.readInt();
            this.malesSingleAge0to15 = aRandomAccessFile.readInt();
            this.femalesTotalAge0to15 = aRandomAccessFile.readInt();
            this.femalesMarriedAge0to15 = aRandomAccessFile.readInt();
            this.femalesSingleAge0to15 = aRandomAccessFile.readInt();
            this.allPeopleTotalAge16to19 = aRandomAccessFile.readInt();
            this.allPeopleMarriedAge16to19 = aRandomAccessFile.readInt();
            this.allPeopleSingleAge16to19 = aRandomAccessFile.readInt();
            this.malesTotalAge16to19 = aRandomAccessFile.readInt();
            this.malesMarriedAge16to19 = aRandomAccessFile.readInt();
            this.malesSingleAge16to19 = aRandomAccessFile.readInt();
            this.femalesTotalAge16to19 = aRandomAccessFile.readInt();
            this.femalesMarriedAge16to19 = aRandomAccessFile.readInt();
            this.femalesSingleAge16to19 = aRandomAccessFile.readInt();
            this.allPeopleTotalAge20to24 = aRandomAccessFile.readInt();
            this.allPeopleMarriedAge20to24 = aRandomAccessFile.readInt();
            this.allPeopleSingleAge20to24 = aRandomAccessFile.readInt();
            this.malesTotalAge20to24 = aRandomAccessFile.readInt();
            this.malesMarriedAge20to24 = aRandomAccessFile.readInt();
            this.malesSingleAge20to24 = aRandomAccessFile.readInt();
            this.femalesTotalAge20to24 = aRandomAccessFile.readInt();
            this.femalesMarriedAge20to24 = aRandomAccessFile.readInt();
            this.femalesSingleAge20to24 = aRandomAccessFile.readInt();
            this.allPeopleTotalAge25to29 = aRandomAccessFile.readInt();
            this.allPeopleMarriedAge25to29 = aRandomAccessFile.readInt();
            this.allPeopleSingleAge25to29 = aRandomAccessFile.readInt();
            this.malesTotalAge25to29 = aRandomAccessFile.readInt();
            this.malesMarriedAge25to29 = aRandomAccessFile.readInt();
            this.malesSingleAge25to29 = aRandomAccessFile.readInt();
            this.femalesTotalAge25to29 = aRandomAccessFile.readInt();
            this.femalesMarriedAge25to29 = aRandomAccessFile.readInt();
            this.femalesSingleAge25to29 = aRandomAccessFile.readInt();
            this.allPeopleTotalAge30to34 = aRandomAccessFile.readInt();
            this.allPeopleMarriedAge30to34 = aRandomAccessFile.readInt();
            this.allPeopleSingleAge30to34 = aRandomAccessFile.readInt();
            this.malesTotalAge30to34 = aRandomAccessFile.readInt();
            this.malesMarriedAge30to34 = aRandomAccessFile.readInt();
            this.malesSingleAge30to34 = aRandomAccessFile.readInt();
            this.femalesTotalAge30to34 = aRandomAccessFile.readInt();
            this.femalesMarriedAge30to34 = aRandomAccessFile.readInt();
            this.femalesSingleAge30to34 = aRandomAccessFile.readInt();
            this.allPeopleTotalAge35to39 = aRandomAccessFile.readInt();
            this.allPeopleMarriedAge35to39 = aRandomAccessFile.readInt();
            this.allPeopleSingleAge35to39 = aRandomAccessFile.readInt();
            this.malesTotalAge35to39 = aRandomAccessFile.readInt();
            this.malesMarriedAge35to39 = aRandomAccessFile.readInt();
            this.malesSingleAge35to39 = aRandomAccessFile.readInt();
            this.femalesTotalAge35to39 = aRandomAccessFile.readInt();
            this.femalesMarriedAge35to39 = aRandomAccessFile.readInt();
            this.femalesSingleAge35to39 = aRandomAccessFile.readInt();
            this.allPeopleTotalAge40to44 = aRandomAccessFile.readInt();
            this.allPeopleMarriedAge40to44 = aRandomAccessFile.readInt();
            this.allPeopleSingleAge40to44 = aRandomAccessFile.readInt();
            this.malesTotalAge40to44 = aRandomAccessFile.readInt();
            this.malesMarriedAge40to44 = aRandomAccessFile.readInt();
            this.malesSingleAge40to44 = aRandomAccessFile.readInt();
            this.femalesTotalAge40to44 = aRandomAccessFile.readInt();
            this.femalesMarriedAge40to44 = aRandomAccessFile.readInt();
            this.femalesSingleAge40to44 = aRandomAccessFile.readInt();
            this.allPeopleTotalAge45to49 = aRandomAccessFile.readInt();
            this.allPeopleMarriedAge45to49 = aRandomAccessFile.readInt();
            this.allPeopleSingleAge45to49 = aRandomAccessFile.readInt();
            this.malesTotalAge45to49 = aRandomAccessFile.readInt();
            this.malesMarriedAge45to49 = aRandomAccessFile.readInt();
            this.malesSingleAge45to49 = aRandomAccessFile.readInt();
            this.femalesTotalAge45to49 = aRandomAccessFile.readInt();
            this.femalesMarriedAge45to49 = aRandomAccessFile.readInt();
            this.femalesSingleAge45to49 = aRandomAccessFile.readInt();
            this.allPeopleTotalAge50to54 = aRandomAccessFile.readInt();
            this.allPeopleMarriedAge50to54 = aRandomAccessFile.readInt();
            this.allPeopleSingleAge50to54 = aRandomAccessFile.readInt();
            this.malesTotalAge50to54 = aRandomAccessFile.readInt();
            this.malesMarriedAge50to54 = aRandomAccessFile.readInt();
            this.malesSingleAge50to54 = aRandomAccessFile.readInt();
            this.femalesTotalAge50to54 = aRandomAccessFile.readInt();
            this.femalesMarriedAge50to54 = aRandomAccessFile.readInt();
            this.femalesSingleAge50to54 = aRandomAccessFile.readInt();
            this.allPeopleTotalAge55to59 = aRandomAccessFile.readInt();
            this.allPeopleMarriedAge55to59 = aRandomAccessFile.readInt();
            this.allPeopleSingleAge55to59 = aRandomAccessFile.readInt();
            this.malesTotalAge55to59 = aRandomAccessFile.readInt();
            this.malesMarriedAge55to59 = aRandomAccessFile.readInt();
            this.malesSingleAge55to59 = aRandomAccessFile.readInt();
            this.femalesTotalAge55to59 = aRandomAccessFile.readInt();
            this.femalesMarriedAge55to59 = aRandomAccessFile.readInt();
            this.femalesSingleAge55to59 = aRandomAccessFile.readInt();
            this.allPeopleTotalAge60to64 = aRandomAccessFile.readInt();
            this.allPeopleMarriedAge60to64 = aRandomAccessFile.readInt();
            this.allPeopleSingleAge60to64 = aRandomAccessFile.readInt();
            this.malesTotalAge60to64 = aRandomAccessFile.readInt();
            this.malesMarriedAge60to64 = aRandomAccessFile.readInt();
            this.malesSingleAge60to64 = aRandomAccessFile.readInt();
            this.femalesTotalAge60to64 = aRandomAccessFile.readInt();
            this.femalesMarriedAge60to64 = aRandomAccessFile.readInt();
            this.femalesSingleAge60to64 = aRandomAccessFile.readInt();
            this.allPeopleTotalAge65to74 = aRandomAccessFile.readInt();
            this.allPeopleMarriedAge65to74 = aRandomAccessFile.readInt();
            this.allPeopleSingleAge65to74 = aRandomAccessFile.readInt();
            this.malesTotalAge65to74 = aRandomAccessFile.readInt();
            this.malesMarriedAge65to74 = aRandomAccessFile.readInt();
            this.malesSingleAge65to74 = aRandomAccessFile.readInt();
            this.femalesTotalAge65to74 = aRandomAccessFile.readInt();
            this.femalesMarriedAge65to74 = aRandomAccessFile.readInt();
            this.femalesSingleAge65to74 = aRandomAccessFile.readInt();
            this.allPeopleTotalAge75to79 = aRandomAccessFile.readInt();
            this.allPeopleMarriedAge75to79 = aRandomAccessFile.readInt();
            this.allPeopleSingleAge75to79 = aRandomAccessFile.readInt();
            this.malesTotalAge75to79 = aRandomAccessFile.readInt();
            this.malesMarriedAge75to79 = aRandomAccessFile.readInt();
            this.malesSingleAge75to79 = aRandomAccessFile.readInt();
            this.femalesTotalAge75to79 = aRandomAccessFile.readInt();
            this.femalesMarriedAge75to79 = aRandomAccessFile.readInt();
            this.femalesSingleAge75to79 = aRandomAccessFile.readInt();
            this.allPeopleTotalAge80to84 = aRandomAccessFile.readInt();
            this.allPeopleMarriedAge80to84 = aRandomAccessFile.readInt();
            this.allPeopleSingleAge80to84 = aRandomAccessFile.readInt();
            this.malesTotalAge80to84 = aRandomAccessFile.readInt();
            this.malesMarriedAge80to84 = aRandomAccessFile.readInt();
            this.malesSingleAge80to84 = aRandomAccessFile.readInt();
            this.femalesTotalAge80to84 = aRandomAccessFile.readInt();
            this.femalesMarriedAge80to84 = aRandomAccessFile.readInt();
            this.femalesSingleAge80to84 = aRandomAccessFile.readInt();
            this.allPeopleTotalAge85to89 = aRandomAccessFile.readInt();
            this.allPeopleMarriedAge85to89 = aRandomAccessFile.readInt();
            this.allPeopleSingleAge85to89 = aRandomAccessFile.readInt();
            this.malesTotalAge85to89 = aRandomAccessFile.readInt();
            this.malesMarriedAge85to89 = aRandomAccessFile.readInt();
            this.malesSingleAge85to89 = aRandomAccessFile.readInt();
            this.femalesTotalAge85to89 = aRandomAccessFile.readInt();
            this.femalesMarriedAge85to89 = aRandomAccessFile.readInt();
            this.femalesSingleAge85to89 = aRandomAccessFile.readInt();
            this.allPeopleTotalAge90AndOver = aRandomAccessFile.readInt();
            this.allPeopleMarriedAge90AndOver = aRandomAccessFile.readInt();
            this.allPeopleSingleAge90AndOver = aRandomAccessFile.readInt();
            this.malesTotalAge90AndOver = aRandomAccessFile.readInt();
            this.malesMarriedAge90AndOver = aRandomAccessFile.readInt();
            this.malesSingleAge90AndOver = aRandomAccessFile.readInt();
            this.femalesTotalAge90AndOver = aRandomAccessFile.readInt();
            this.femalesMarriedAge90AndOver = aRandomAccessFile.readInt();
            this.femalesSingleAge90AndOver = aRandomAccessFile.readInt();
        } catch (IOException ioe0) {
            // ioe0.printStackTrace();
            throw ioe0;
        }
    }

    /**
     * Initialises all fields.
     */
    protected void _Init() {
        super._Init();
        this.allPeopleTotal = Integer.MIN_VALUE;
        this.allPeopleMarried = Integer.MIN_VALUE;
        this.allPeopleSingle = Integer.MIN_VALUE;
        this.malesTotal = Integer.MIN_VALUE;
        this.malesMarried = Integer.MIN_VALUE;
        this.malesSingle = Integer.MIN_VALUE;
        this.femalesTotal = Integer.MIN_VALUE;
        this.femalesMarried = Integer.MIN_VALUE;
        this.femalesSingle = Integer.MIN_VALUE;
        this.allPeopleTotalAge0to15 = Integer.MIN_VALUE;
        this.allPeopleMarriedAge0to15 = Integer.MIN_VALUE;
        this.allPeopleSingleAge0to15 = Integer.MIN_VALUE;
        this.malesTotalAge0to15 = Integer.MIN_VALUE;
        this.malesMarriedAge0to15 = Integer.MIN_VALUE;
        this.malesSingleAge0to15 = Integer.MIN_VALUE;
        this.femalesTotalAge0to15 = Integer.MIN_VALUE;
        this.femalesMarriedAge0to15 = Integer.MIN_VALUE;
        this.femalesSingleAge0to15 = Integer.MIN_VALUE;
        this.allPeopleTotalAge16to19 = Integer.MIN_VALUE;
        this.allPeopleMarriedAge16to19 = Integer.MIN_VALUE;
        this.allPeopleSingleAge16to19 = Integer.MIN_VALUE;
        this.malesTotalAge16to19 = Integer.MIN_VALUE;
        this.malesMarriedAge16to19 = Integer.MIN_VALUE;
        this.malesSingleAge16to19 = Integer.MIN_VALUE;
        this.femalesTotalAge16to19 = Integer.MIN_VALUE;
        this.femalesMarriedAge16to19 = Integer.MIN_VALUE;
        this.femalesSingleAge16to19 = Integer.MIN_VALUE;
        this.allPeopleTotalAge20to24 = Integer.MIN_VALUE;
        this.allPeopleMarriedAge20to24 = Integer.MIN_VALUE;
        this.allPeopleSingleAge20to24 = Integer.MIN_VALUE;
        this.malesTotalAge20to24 = Integer.MIN_VALUE;
        this.malesMarriedAge20to24 = Integer.MIN_VALUE;
        this.malesSingleAge20to24 = Integer.MIN_VALUE;
        this.femalesTotalAge20to24 = Integer.MIN_VALUE;
        this.femalesMarriedAge20to24 = Integer.MIN_VALUE;
        this.femalesSingleAge20to24 = Integer.MIN_VALUE;
        this.allPeopleTotalAge25to29 = Integer.MIN_VALUE;
        this.allPeopleMarriedAge25to29 = Integer.MIN_VALUE;
        this.allPeopleSingleAge25to29 = Integer.MIN_VALUE;
        this.malesTotalAge25to29 = Integer.MIN_VALUE;
        this.malesMarriedAge25to29 = Integer.MIN_VALUE;
        this.malesSingleAge25to29 = Integer.MIN_VALUE;
        this.femalesTotalAge25to29 = Integer.MIN_VALUE;
        this.femalesMarriedAge25to29 = Integer.MIN_VALUE;
        this.femalesSingleAge25to29 = Integer.MIN_VALUE;
        this.allPeopleTotalAge30to34 = Integer.MIN_VALUE;
        this.allPeopleMarriedAge30to34 = Integer.MIN_VALUE;
        this.allPeopleSingleAge30to34 = Integer.MIN_VALUE;
        this.malesTotalAge30to34 = Integer.MIN_VALUE;
        this.malesMarriedAge30to34 = Integer.MIN_VALUE;
        this.malesSingleAge30to34 = Integer.MIN_VALUE;
        this.femalesTotalAge30to34 = Integer.MIN_VALUE;
        this.femalesMarriedAge30to34 = Integer.MIN_VALUE;
        this.femalesSingleAge30to34 = Integer.MIN_VALUE;
        this.allPeopleTotalAge35to39 = Integer.MIN_VALUE;
        this.allPeopleMarriedAge35to39 = Integer.MIN_VALUE;
        this.allPeopleSingleAge35to39 = Integer.MIN_VALUE;
        this.malesTotalAge35to39 = Integer.MIN_VALUE;
        this.malesMarriedAge35to39 = Integer.MIN_VALUE;
        this.malesSingleAge35to39 = Integer.MIN_VALUE;
        this.femalesTotalAge35to39 = Integer.MIN_VALUE;
        this.femalesMarriedAge35to39 = Integer.MIN_VALUE;
        this.femalesSingleAge35to39 = Integer.MIN_VALUE;
        this.allPeopleTotalAge40to44 = Integer.MIN_VALUE;
        this.allPeopleMarriedAge40to44 = Integer.MIN_VALUE;
        this.allPeopleSingleAge40to44 = Integer.MIN_VALUE;
        this.malesTotalAge40to44 = Integer.MIN_VALUE;
        this.malesMarriedAge40to44 = Integer.MIN_VALUE;
        this.malesSingleAge40to44 = Integer.MIN_VALUE;
        this.femalesTotalAge40to44 = Integer.MIN_VALUE;
        this.femalesMarriedAge40to44 = Integer.MIN_VALUE;
        this.femalesSingleAge40to44 = Integer.MIN_VALUE;
        this.allPeopleTotalAge45to49 = Integer.MIN_VALUE;
        this.allPeopleMarriedAge45to49 = Integer.MIN_VALUE;
        this.allPeopleSingleAge45to49 = Integer.MIN_VALUE;
        this.malesTotalAge45to49 = Integer.MIN_VALUE;
        this.malesMarriedAge45to49 = Integer.MIN_VALUE;
        this.malesSingleAge45to49 = Integer.MIN_VALUE;
        this.femalesTotalAge45to49 = Integer.MIN_VALUE;
        this.femalesMarriedAge45to49 = Integer.MIN_VALUE;
        this.femalesSingleAge45to49 = Integer.MIN_VALUE;
        this.allPeopleTotalAge50to54 = Integer.MIN_VALUE;
        this.allPeopleMarriedAge50to54 = Integer.MIN_VALUE;
        this.allPeopleSingleAge50to54 = Integer.MIN_VALUE;
        this.malesTotalAge50to54 = Integer.MIN_VALUE;
        this.malesMarriedAge50to54 = Integer.MIN_VALUE;
        this.malesSingleAge50to54 = Integer.MIN_VALUE;
        this.femalesTotalAge50to54 = Integer.MIN_VALUE;
        this.femalesMarriedAge50to54 = Integer.MIN_VALUE;
        this.femalesSingleAge50to54 = Integer.MIN_VALUE;
        this.allPeopleTotalAge55to59 = Integer.MIN_VALUE;
        this.allPeopleMarriedAge55to59 = Integer.MIN_VALUE;
        this.allPeopleSingleAge55to59 = Integer.MIN_VALUE;
        this.malesTotalAge55to59 = Integer.MIN_VALUE;
        this.malesMarriedAge55to59 = Integer.MIN_VALUE;
        this.malesSingleAge55to59 = Integer.MIN_VALUE;
        this.femalesTotalAge55to59 = Integer.MIN_VALUE;
        this.femalesMarriedAge55to59 = Integer.MIN_VALUE;
        this.femalesSingleAge55to59 = Integer.MIN_VALUE;
        this.allPeopleTotalAge60to64 = Integer.MIN_VALUE;
        this.allPeopleMarriedAge60to64 = Integer.MIN_VALUE;
        this.allPeopleSingleAge60to64 = Integer.MIN_VALUE;
        this.malesTotalAge60to64 = Integer.MIN_VALUE;
        this.malesMarriedAge60to64 = Integer.MIN_VALUE;
        this.malesSingleAge60to64 = Integer.MIN_VALUE;
        this.femalesTotalAge60to64 = Integer.MIN_VALUE;
        this.femalesMarriedAge60to64 = Integer.MIN_VALUE;
        this.femalesSingleAge60to64 = Integer.MIN_VALUE;
        this.allPeopleTotalAge65to74 = Integer.MIN_VALUE;
        this.allPeopleMarriedAge65to74 = Integer.MIN_VALUE;
        this.allPeopleSingleAge65to74 = Integer.MIN_VALUE;
        this.malesTotalAge65to74 = Integer.MIN_VALUE;
        this.malesMarriedAge65to74 = Integer.MIN_VALUE;
        this.malesSingleAge65to74 = Integer.MIN_VALUE;
        this.femalesTotalAge65to74 = Integer.MIN_VALUE;
        this.femalesMarriedAge65to74 = Integer.MIN_VALUE;
        this.femalesSingleAge65to74 = Integer.MIN_VALUE;
        this.allPeopleTotalAge75to79 = Integer.MIN_VALUE;
        this.allPeopleMarriedAge75to79 = Integer.MIN_VALUE;
        this.allPeopleSingleAge75to79 = Integer.MIN_VALUE;
        this.malesTotalAge75to79 = Integer.MIN_VALUE;
        this.malesMarriedAge75to79 = Integer.MIN_VALUE;
        this.malesSingleAge75to79 = Integer.MIN_VALUE;
        this.femalesTotalAge75to79 = Integer.MIN_VALUE;
        this.femalesMarriedAge75to79 = Integer.MIN_VALUE;
        this.femalesSingleAge75to79 = Integer.MIN_VALUE;
        this.allPeopleTotalAge80to84 = Integer.MIN_VALUE;
        this.allPeopleMarriedAge80to84 = Integer.MIN_VALUE;
        this.allPeopleSingleAge80to84 = Integer.MIN_VALUE;
        this.malesTotalAge80to84 = Integer.MIN_VALUE;
        this.malesMarriedAge80to84 = Integer.MIN_VALUE;
        this.malesSingleAge80to84 = Integer.MIN_VALUE;
        this.femalesTotalAge80to84 = Integer.MIN_VALUE;
        this.femalesMarriedAge80to84 = Integer.MIN_VALUE;
        this.femalesSingleAge80to84 = Integer.MIN_VALUE;
        this.allPeopleTotalAge85to89 = Integer.MIN_VALUE;
        this.allPeopleMarriedAge85to89 = Integer.MIN_VALUE;
        this.allPeopleSingleAge85to89 = Integer.MIN_VALUE;
        this.malesTotalAge85to89 = Integer.MIN_VALUE;
        this.malesMarriedAge85to89 = Integer.MIN_VALUE;
        this.malesSingleAge85to89 = Integer.MIN_VALUE;
        this.femalesTotalAge85to89 = Integer.MIN_VALUE;
        this.femalesMarriedAge85to89 = Integer.MIN_VALUE;
        this.femalesSingleAge85to89 = Integer.MIN_VALUE;
        this.allPeopleTotalAge90AndOver = Integer.MIN_VALUE;
        this.allPeopleMarriedAge90AndOver = Integer.MIN_VALUE;
        this.allPeopleSingleAge90AndOver = Integer.MIN_VALUE;
        this.malesTotalAge90AndOver = Integer.MIN_VALUE;
        this.malesMarriedAge90AndOver = Integer.MIN_VALUE;
        this.malesSingleAge90AndOver = Integer.MIN_VALUE;
        this.femalesTotalAge90AndOver = Integer.MIN_VALUE;
        this.femalesMarriedAge90AndOver = Integer.MIN_VALUE;
        this.femalesSingleAge90AndOver = Integer.MIN_VALUE;
    }

    /**
     * Initialises all fields as zero.
     */
    protected void initZero() {
        super._Init();
        this.allPeopleTotal = 0;
        this.allPeopleMarried = 0;
        this.allPeopleSingle = 0;
        this.malesTotal = 0;
        this.malesMarried = 0;
        this.malesSingle = 0;
        this.femalesTotal = 0;
        this.femalesMarried = 0;
        this.femalesSingle = 0;
        this.allPeopleTotalAge0to15 = 0;
        this.allPeopleMarriedAge0to15 = 0;
        this.allPeopleSingleAge0to15 = 0;
        this.malesTotalAge0to15 = 0;
        this.malesMarriedAge0to15 = 0;
        this.malesSingleAge0to15 = 0;
        this.femalesTotalAge0to15 = 0;
        this.femalesMarriedAge0to15 = 0;
        this.femalesSingleAge0to15 = 0;
        this.allPeopleTotalAge16to19 = 0;
        this.allPeopleMarriedAge16to19 = 0;
        this.allPeopleSingleAge16to19 = 0;
        this.malesTotalAge16to19 = 0;
        this.malesMarriedAge16to19 = 0;
        this.malesSingleAge16to19 = 0;
        this.femalesTotalAge16to19 = 0;
        this.femalesMarriedAge16to19 = 0;
        this.femalesSingleAge16to19 = 0;
        this.allPeopleTotalAge20to24 = 0;
        this.allPeopleMarriedAge20to24 = 0;
        this.allPeopleSingleAge20to24 = 0;
        this.malesTotalAge20to24 = 0;
        this.malesMarriedAge20to24 = 0;
        this.malesSingleAge20to24 = 0;
        this.femalesTotalAge20to24 = 0;
        this.femalesMarriedAge20to24 = 0;
        this.femalesSingleAge20to24 = 0;
        this.allPeopleTotalAge25to29 = 0;
        this.allPeopleMarriedAge25to29 = 0;
        this.allPeopleSingleAge25to29 = 0;
        this.malesTotalAge25to29 = 0;
        this.malesMarriedAge25to29 = 0;
        this.malesSingleAge25to29 = 0;
        this.femalesTotalAge25to29 = 0;
        this.femalesMarriedAge25to29 = 0;
        this.femalesSingleAge25to29 = 0;
        this.allPeopleTotalAge30to34 = 0;
        this.allPeopleMarriedAge30to34 = 0;
        this.allPeopleSingleAge30to34 = 0;
        this.malesTotalAge30to34 = 0;
        this.malesMarriedAge30to34 = 0;
        this.malesSingleAge30to34 = 0;
        this.femalesTotalAge30to34 = 0;
        this.femalesMarriedAge30to34 = 0;
        this.femalesSingleAge30to34 = 0;
        this.allPeopleTotalAge35to39 = 0;
        this.allPeopleMarriedAge35to39 = 0;
        this.allPeopleSingleAge35to39 = 0;
        this.malesTotalAge35to39 = 0;
        this.malesMarriedAge35to39 = 0;
        this.malesSingleAge35to39 = 0;
        this.femalesTotalAge35to39 = 0;
        this.femalesMarriedAge35to39 = 0;
        this.femalesSingleAge35to39 = 0;
        this.allPeopleTotalAge40to44 = 0;
        this.allPeopleMarriedAge40to44 = 0;
        this.allPeopleSingleAge40to44 = 0;
        this.malesTotalAge40to44 = 0;
        this.malesMarriedAge40to44 = 0;
        this.malesSingleAge40to44 = 0;
        this.femalesTotalAge40to44 = 0;
        this.femalesMarriedAge40to44 = 0;
        this.femalesSingleAge40to44 = 0;
        this.allPeopleTotalAge45to49 = 0;
        this.allPeopleMarriedAge45to49 = 0;
        this.allPeopleSingleAge45to49 = 0;
        this.malesTotalAge45to49 = 0;
        this.malesMarriedAge45to49 = 0;
        this.malesSingleAge45to49 = 0;
        this.femalesTotalAge45to49 = 0;
        this.femalesMarriedAge45to49 = 0;
        this.femalesSingleAge45to49 = 0;
        this.allPeopleTotalAge50to54 = 0;
        this.allPeopleMarriedAge50to54 = 0;
        this.allPeopleSingleAge50to54 = 0;
        this.malesTotalAge50to54 = 0;
        this.malesMarriedAge50to54 = 0;
        this.malesSingleAge50to54 = 0;
        this.femalesTotalAge50to54 = 0;
        this.femalesMarriedAge50to54 = 0;
        this.femalesSingleAge50to54 = 0;
        this.allPeopleTotalAge55to59 = 0;
        this.allPeopleMarriedAge55to59 = 0;
        this.allPeopleSingleAge55to59 = 0;
        this.malesTotalAge55to59 = 0;
        this.malesMarriedAge55to59 = 0;
        this.malesSingleAge55to59 = 0;
        this.femalesTotalAge55to59 = 0;
        this.femalesMarriedAge55to59 = 0;
        this.femalesSingleAge55to59 = 0;
        this.allPeopleTotalAge60to64 = 0;
        this.allPeopleMarriedAge60to64 = 0;
        this.allPeopleSingleAge60to64 = 0;
        this.malesTotalAge60to64 = 0;
        this.malesMarriedAge60to64 = 0;
        this.malesSingleAge60to64 = 0;
        this.femalesTotalAge60to64 = 0;
        this.femalesMarriedAge60to64 = 0;
        this.femalesSingleAge60to64 = 0;
        this.allPeopleTotalAge65to74 = 0;
        this.allPeopleMarriedAge65to74 = 0;
        this.allPeopleSingleAge65to74 = 0;
        this.malesTotalAge65to74 = 0;
        this.malesMarriedAge65to74 = 0;
        this.malesSingleAge65to74 = 0;
        this.femalesTotalAge65to74 = 0;
        this.femalesMarriedAge65to74 = 0;
        this.femalesSingleAge65to74 = 0;
        this.allPeopleTotalAge75to79 = 0;
        this.allPeopleMarriedAge75to79 = 0;
        this.allPeopleSingleAge75to79 = 0;
        this.malesTotalAge75to79 = 0;
        this.malesMarriedAge75to79 = 0;
        this.malesSingleAge75to79 = 0;
        this.femalesTotalAge75to79 = 0;
        this.femalesMarriedAge75to79 = 0;
        this.femalesSingleAge75to79 = 0;
        this.allPeopleTotalAge80to84 = 0;
        this.allPeopleMarriedAge80to84 = 0;
        this.allPeopleSingleAge80to84 = 0;
        this.malesTotalAge80to84 = 0;
        this.malesMarriedAge80to84 = 0;
        this.malesSingleAge80to84 = 0;
        this.femalesTotalAge80to84 = 0;
        this.femalesMarriedAge80to84 = 0;
        this.femalesSingleAge80to84 = 0;
        this.allPeopleTotalAge85to89 = 0;
        this.allPeopleMarriedAge85to89 = 0;
        this.allPeopleSingleAge85to89 = 0;
        this.malesTotalAge85to89 = 0;
        this.malesMarriedAge85to89 = 0;
        this.malesSingleAge85to89 = 0;
        this.femalesTotalAge85to89 = 0;
        this.femalesMarriedAge85to89 = 0;
        this.femalesSingleAge85to89 = 0;
        this.allPeopleTotalAge90AndOver = 0;
        this.allPeopleMarriedAge90AndOver = 0;
        this.allPeopleSingleAge90AndOver = 0;
        this.malesTotalAge90AndOver = 0;
        this.malesMarriedAge90AndOver = 0;
        this.malesSingleAge90AndOver = 0;
        this.femalesTotalAge90AndOver = 0;
        this.femalesMarriedAge90AndOver = 0;
        this.femalesSingleAge90AndOver = 0;
    }

    /**
     * Initialises from <code>aCAS002DataRecord</code>.
     *
     * @param aCAS002DataRecord
     *            The <code>CAS002DataRecord</code> used to initialise
     *            <code>this</code>.
     */
    protected void init(CAS002DataRecord aCAS002DataRecord) {
        super.init(aCAS002DataRecord);
        this.allPeopleTotal = aCAS002DataRecord.allPeopleTotal;
        this.allPeopleMarried = aCAS002DataRecord.allPeopleMarried;
        this.allPeopleSingle = aCAS002DataRecord.allPeopleSingle;
        this.malesTotal = aCAS002DataRecord.malesTotal;
        this.malesMarried = aCAS002DataRecord.malesMarried;
        this.malesSingle = aCAS002DataRecord.malesSingle;
        this.femalesTotal = aCAS002DataRecord.femalesTotal;
        this.femalesMarried = aCAS002DataRecord.femalesMarried;
        this.femalesSingle = aCAS002DataRecord.femalesSingle;
        this.allPeopleTotalAge0to15 = aCAS002DataRecord.allPeopleTotalAge0to15;
        this.allPeopleMarriedAge0to15 = aCAS002DataRecord.allPeopleMarriedAge0to15;
        this.allPeopleSingleAge0to15 = aCAS002DataRecord.allPeopleSingleAge0to15;
        this.malesTotalAge0to15 = aCAS002DataRecord.malesTotalAge0to15;
        this.malesMarriedAge0to15 = aCAS002DataRecord.malesMarriedAge0to15;
        this.malesSingleAge0to15 = aCAS002DataRecord.malesSingleAge0to15;
        this.femalesTotalAge0to15 = aCAS002DataRecord.femalesTotalAge0to15;
        this.femalesMarriedAge0to15 = aCAS002DataRecord.femalesMarriedAge0to15;
        this.femalesSingleAge0to15 = aCAS002DataRecord.femalesSingleAge0to15;
        this.allPeopleTotalAge16to19 = aCAS002DataRecord.allPeopleTotalAge16to19;
        this.allPeopleMarriedAge16to19 = aCAS002DataRecord.allPeopleMarriedAge16to19;
        this.allPeopleSingleAge16to19 = aCAS002DataRecord.allPeopleSingleAge16to19;
        this.malesTotalAge16to19 = aCAS002DataRecord.malesTotalAge16to19;
        this.malesMarriedAge16to19 = aCAS002DataRecord.malesMarriedAge16to19;
        this.malesSingleAge16to19 = aCAS002DataRecord.malesSingleAge16to19;
        this.femalesTotalAge16to19 = aCAS002DataRecord.femalesTotalAge16to19;
        this.femalesMarriedAge16to19 = aCAS002DataRecord.femalesMarriedAge16to19;
        this.femalesSingleAge16to19 = aCAS002DataRecord.femalesSingleAge16to19;
        this.allPeopleTotalAge20to24 = aCAS002DataRecord.allPeopleTotalAge20to24;
        this.allPeopleMarriedAge20to24 = aCAS002DataRecord.allPeopleMarriedAge20to24;
        this.allPeopleSingleAge20to24 = aCAS002DataRecord.allPeopleSingleAge20to24;
        this.malesTotalAge20to24 = aCAS002DataRecord.malesTotalAge20to24;
        this.malesMarriedAge20to24 = aCAS002DataRecord.malesMarriedAge20to24;
        this.malesSingleAge20to24 = aCAS002DataRecord.malesSingleAge20to24;
        this.femalesTotalAge20to24 = aCAS002DataRecord.femalesTotalAge20to24;
        this.femalesMarriedAge20to24 = aCAS002DataRecord.femalesMarriedAge20to24;
        this.femalesSingleAge20to24 = aCAS002DataRecord.femalesSingleAge20to24;
        this.allPeopleTotalAge25to29 = aCAS002DataRecord.allPeopleTotalAge25to29;
        this.allPeopleMarriedAge25to29 = aCAS002DataRecord.allPeopleMarriedAge25to29;
        this.allPeopleSingleAge25to29 = aCAS002DataRecord.allPeopleSingleAge25to29;
        this.malesTotalAge25to29 = aCAS002DataRecord.malesTotalAge25to29;
        this.malesMarriedAge25to29 = aCAS002DataRecord.malesMarriedAge25to29;
        this.malesSingleAge25to29 = aCAS002DataRecord.malesSingleAge25to29;
        this.femalesTotalAge25to29 = aCAS002DataRecord.femalesTotalAge25to29;
        this.femalesMarriedAge25to29 = aCAS002DataRecord.femalesMarriedAge25to29;
        this.femalesSingleAge25to29 = aCAS002DataRecord.femalesSingleAge25to29;
        this.allPeopleTotalAge30to34 = aCAS002DataRecord.allPeopleTotalAge30to34;
        this.allPeopleMarriedAge30to34 = aCAS002DataRecord.allPeopleMarriedAge30to34;
        this.allPeopleSingleAge30to34 = aCAS002DataRecord.allPeopleSingleAge30to34;
        this.malesTotalAge30to34 = aCAS002DataRecord.malesTotalAge30to34;
        this.malesMarriedAge30to34 = aCAS002DataRecord.malesMarriedAge30to34;
        this.malesSingleAge30to34 = aCAS002DataRecord.malesSingleAge30to34;
        this.femalesTotalAge30to34 = aCAS002DataRecord.femalesTotalAge30to34;
        this.femalesMarriedAge30to34 = aCAS002DataRecord.femalesMarriedAge30to34;
        this.femalesSingleAge30to34 = aCAS002DataRecord.femalesSingleAge30to34;
        this.allPeopleTotalAge35to39 = aCAS002DataRecord.allPeopleTotalAge35to39;
        this.allPeopleMarriedAge35to39 = aCAS002DataRecord.allPeopleMarriedAge35to39;
        this.allPeopleSingleAge35to39 = aCAS002DataRecord.allPeopleSingleAge35to39;
        this.malesTotalAge35to39 = aCAS002DataRecord.malesTotalAge35to39;
        this.malesMarriedAge35to39 = aCAS002DataRecord.malesMarriedAge35to39;
        this.malesSingleAge35to39 = aCAS002DataRecord.malesSingleAge35to39;
        this.femalesTotalAge35to39 = aCAS002DataRecord.femalesTotalAge35to39;
        this.femalesMarriedAge35to39 = aCAS002DataRecord.femalesMarriedAge35to39;
        this.femalesSingleAge35to39 = aCAS002DataRecord.femalesSingleAge35to39;
        this.allPeopleTotalAge40to44 = aCAS002DataRecord.allPeopleTotalAge40to44;
        this.allPeopleMarriedAge40to44 = aCAS002DataRecord.allPeopleMarriedAge40to44;
        this.allPeopleSingleAge40to44 = aCAS002DataRecord.allPeopleSingleAge40to44;
        this.malesTotalAge40to44 = aCAS002DataRecord.malesTotalAge40to44;
        this.malesMarriedAge40to44 = aCAS002DataRecord.malesMarriedAge40to44;
        this.malesSingleAge40to44 = aCAS002DataRecord.malesSingleAge40to44;
        this.femalesTotalAge40to44 = aCAS002DataRecord.femalesTotalAge40to44;
        this.femalesMarriedAge40to44 = aCAS002DataRecord.femalesMarriedAge40to44;
        this.femalesSingleAge40to44 = aCAS002DataRecord.femalesSingleAge40to44;
        this.allPeopleTotalAge45to49 = aCAS002DataRecord.allPeopleTotalAge45to49;
        this.allPeopleMarriedAge45to49 = aCAS002DataRecord.allPeopleMarriedAge45to49;
        this.allPeopleSingleAge45to49 = aCAS002DataRecord.allPeopleSingleAge45to49;
        this.malesTotalAge45to49 = aCAS002DataRecord.malesTotalAge45to49;
        this.malesMarriedAge45to49 = aCAS002DataRecord.malesMarriedAge45to49;
        this.malesSingleAge45to49 = aCAS002DataRecord.malesSingleAge45to49;
        this.femalesTotalAge45to49 = aCAS002DataRecord.femalesTotalAge45to49;
        this.femalesMarriedAge45to49 = aCAS002DataRecord.femalesMarriedAge45to49;
        this.femalesSingleAge45to49 = aCAS002DataRecord.femalesSingleAge45to49;
        this.allPeopleTotalAge50to54 = aCAS002DataRecord.allPeopleTotalAge50to54;
        this.allPeopleMarriedAge50to54 = aCAS002DataRecord.allPeopleMarriedAge50to54;
        this.allPeopleSingleAge50to54 = aCAS002DataRecord.allPeopleSingleAge50to54;
        this.malesTotalAge50to54 = aCAS002DataRecord.malesTotalAge50to54;
        this.malesMarriedAge50to54 = aCAS002DataRecord.malesMarriedAge50to54;
        this.malesSingleAge50to54 = aCAS002DataRecord.malesSingleAge50to54;
        this.femalesTotalAge50to54 = aCAS002DataRecord.femalesTotalAge50to54;
        this.femalesMarriedAge50to54 = aCAS002DataRecord.femalesMarriedAge50to54;
        this.femalesSingleAge50to54 = aCAS002DataRecord.femalesSingleAge50to54;
        this.allPeopleTotalAge65to74 = aCAS002DataRecord.allPeopleTotalAge65to74;
        this.allPeopleMarriedAge65to74 = aCAS002DataRecord.allPeopleMarriedAge65to74;
        this.allPeopleSingleAge65to74 = aCAS002DataRecord.allPeopleSingleAge65to74;
        this.malesTotalAge65to74 = aCAS002DataRecord.malesTotalAge65to74;
        this.malesMarriedAge65to74 = aCAS002DataRecord.malesMarriedAge65to74;
        this.malesSingleAge65to74 = aCAS002DataRecord.malesSingleAge65to74;
        this.femalesTotalAge65to74 = aCAS002DataRecord.femalesTotalAge65to74;
        this.femalesMarriedAge65to74 = aCAS002DataRecord.femalesMarriedAge65to74;
        this.femalesSingleAge65to74 = aCAS002DataRecord.femalesSingleAge65to74;
        this.allPeopleTotalAge75to79 = aCAS002DataRecord.allPeopleTotalAge75to79;
        this.allPeopleMarriedAge75to79 = aCAS002DataRecord.allPeopleMarriedAge75to79;
        this.allPeopleSingleAge75to79 = aCAS002DataRecord.allPeopleSingleAge75to79;
        this.malesTotalAge75to79 = aCAS002DataRecord.malesTotalAge75to79;
        this.malesMarriedAge75to79 = aCAS002DataRecord.malesMarriedAge75to79;
        this.malesSingleAge75to79 = aCAS002DataRecord.malesSingleAge75to79;
        this.femalesTotalAge75to79 = aCAS002DataRecord.femalesTotalAge75to79;
        this.femalesMarriedAge75to79 = aCAS002DataRecord.femalesMarriedAge75to79;
        this.femalesSingleAge75to79 = aCAS002DataRecord.femalesSingleAge75to79;
        this.allPeopleTotalAge80to84 = aCAS002DataRecord.allPeopleTotalAge80to84;
        this.allPeopleMarriedAge80to84 = aCAS002DataRecord.allPeopleMarriedAge80to84;
        this.allPeopleSingleAge80to84 = aCAS002DataRecord.allPeopleSingleAge80to84;
        this.malesTotalAge80to84 = aCAS002DataRecord.malesTotalAge80to84;
        this.malesMarriedAge80to84 = aCAS002DataRecord.malesMarriedAge80to84;
        this.malesSingleAge80to84 = aCAS002DataRecord.malesSingleAge80to84;
        this.femalesTotalAge80to84 = aCAS002DataRecord.femalesTotalAge80to84;
        this.femalesMarriedAge80to84 = aCAS002DataRecord.femalesMarriedAge80to84;
        this.femalesSingleAge80to84 = aCAS002DataRecord.femalesSingleAge80to84;
        this.allPeopleTotalAge85to89 = aCAS002DataRecord.allPeopleTotalAge85to89;
        this.allPeopleMarriedAge85to89 = aCAS002DataRecord.allPeopleMarriedAge85to89;
        this.allPeopleSingleAge85to89 = aCAS002DataRecord.allPeopleSingleAge85to89;
        this.malesTotalAge85to89 = aCAS002DataRecord.malesTotalAge85to89;
        this.malesMarriedAge85to89 = aCAS002DataRecord.malesMarriedAge85to89;
        this.malesSingleAge85to89 = aCAS002DataRecord.malesSingleAge85to89;
        this.femalesTotalAge85to89 = aCAS002DataRecord.femalesTotalAge85to89;
        this.femalesMarriedAge85to89 = aCAS002DataRecord.femalesMarriedAge85to89;
        this.femalesSingleAge85to89 = aCAS002DataRecord.femalesSingleAge85to89;
        this.allPeopleTotalAge90AndOver = aCAS002DataRecord.allPeopleTotalAge90AndOver;
        this.allPeopleMarriedAge90AndOver = aCAS002DataRecord.allPeopleMarriedAge90AndOver;
        this.allPeopleSingleAge90AndOver = aCAS002DataRecord.allPeopleSingleAge90AndOver;
        this.malesTotalAge90AndOver = aCAS002DataRecord.malesTotalAge90AndOver;
        this.malesMarriedAge90AndOver = aCAS002DataRecord.malesMarriedAge90AndOver;
        this.malesSingleAge90AndOver = aCAS002DataRecord.malesSingleAge90AndOver;
        this.femalesTotalAge90AndOver = aCAS002DataRecord.femalesTotalAge90AndOver;
        this.femalesMarriedAge90AndOver = aCAS002DataRecord.femalesMarriedAge90AndOver;
        this.femalesSingleAge90AndOver = aCAS002DataRecord.femalesSingleAge90AndOver;
    }

    /**
     * Returns a string description of this;
     * @return 
     */
    public String toString() {
        String string = super.toString() + ", allPeopleTotal " + allPeopleTotal + ", allPeopleMarried " + allPeopleMarried + ", allPeopleSingle " + allPeopleSingle + ", malesTotal " + malesTotal + ", malesMarried " + malesMarried + ", malesSingle " + malesSingle + ", femalesTotal " + femalesTotal + ", femalesMarried " + femalesMarried + ", femalesSingle " + femalesSingle + ", allPeopleTotalAge0to15 " + allPeopleTotalAge0to15 + ", allPeopleMarriedAge0to15 " + allPeopleMarriedAge0to15 + ", allPeopleSingleAge0to15 " + allPeopleSingleAge0to15 + ", malesTotalAge0to15 " + malesTotalAge0to15 + ", malesMarriedAge0to15 " + malesMarriedAge0to15 + ", malesSingleAge0to15 " + malesSingleAge0to15 + ", femalesTotalAge0to15 " + femalesTotalAge0to15 + ", femalesMarriedAge0to15 " + femalesMarriedAge0to15 + ", femalesSingleAge0to15 " + femalesSingleAge0to15 + ", allPeopleTotalAge16to19 " + allPeopleTotalAge16to19 + ", allPeopleMarriedAge16to19 " + allPeopleMarriedAge16to19 + ", allPeopleSingleAge16to19 " + allPeopleSingleAge16to19 + ", malesTotalAge16to19 " + malesTotalAge16to19 + ", malesMarriedAge16to19 " + malesMarriedAge16to19 + ", malesSingleAge16to19 " + malesSingleAge16to19 + ", femalesTotalAge16to19 " + femalesTotalAge16to19 + ", femalesMarriedAge16to19 " + femalesMarriedAge16to19 + ", femalesSingleAge16to19 " + femalesSingleAge16to19 + ", allPeopleTotalAge20to24 " + allPeopleTotalAge20to24 + ", allPeopleMarriedAge20to24 " + allPeopleMarriedAge20to24 + ", allPeopleSingleAge20to24 " + allPeopleSingleAge20to24 + ", malesTotalAge20to24 " + malesTotalAge20to24 + ", malesMarriedAge20to24 " + malesMarriedAge20to24 + ", malesSingleAge20to24 " + malesSingleAge20to24 + ", femalesTotalAge20to24 " + femalesTotalAge20to24 + ", femalesMarriedAge20to24 " + femalesMarriedAge20to24 + ", femalesSingleAge20to24 " + femalesSingleAge20to24 + ", allPeopleTotalAge25to29 " + allPeopleTotalAge25to29 + ", allPeopleMarriedAge25to29 " + allPeopleMarriedAge25to29 + ", allPeopleSingleAge25to29 " + allPeopleSingleAge25to29 + ", malesTotalAge25to29 " + malesTotalAge25to29 + ", malesMarriedAge25to29 " + malesMarriedAge25to29 + ", malesSingleAge25to29 " + malesSingleAge25to29 + ", femalesTotalAge25to29 " + femalesTotalAge25to29 + ", femalesMarriedAge25to29 " + femalesMarriedAge25to29 + ", femalesSingleAge25to29 " + femalesSingleAge25to29 + ", allPeopleTotalAge30to34 " + allPeopleTotalAge30to34 + ", allPeopleMarriedAge30to34 " + allPeopleMarriedAge30to34 + ", allPeopleSingleAge30to34 " + allPeopleSingleAge30to34 + ", malesTotalAge30to34 " + malesTotalAge30to34 + ", malesMarriedAge30to34 " + malesMarriedAge30to34 + ", malesSingleAge30to34 " + malesSingleAge30to34 + ", femalesTotalAge30to34 " + femalesTotalAge30to34 + ", femalesMarriedAge30to34 " + femalesMarriedAge30to34 + ", femalesSingleAge30to34 " + femalesSingleAge30to34 + ", allPeopleTotalAge35to39 " + allPeopleTotalAge35to39 + ", allPeopleMarriedAge35to39 " + allPeopleMarriedAge35to39 + ", allPeopleSingleAge35to39 " + allPeopleSingleAge35to39 + ", malesTotalAge35to39 " + malesTotalAge35to39 + ", malesMarriedAge35to39 " + malesMarriedAge35to39 + ", malesSingleAge35to39 " + malesSingleAge35to39 + ", femalesTotalAge35to39 " + femalesTotalAge35to39 + ", femalesMarriedAge35to39 " + femalesMarriedAge35to39 + ", femalesSingleAge35to39 " + femalesSingleAge35to39 + ", allPeopleTotalAge40to44 " + allPeopleTotalAge40to44 + ", allPeopleMarriedAge40to44 " + allPeopleMarriedAge40to44 + ", allPeopleSingleAge40to44 " + allPeopleSingleAge40to44 + ", malesTotalAge40to44 " + malesTotalAge40to44 + ", malesMarriedAge40to44 " + malesMarriedAge40to44 + ", malesSingleAge40to44 " + malesSingleAge40to44 + ", femalesTotalAge40to44 " + femalesTotalAge40to44 + ", femalesMarriedAge40to44 " + femalesMarriedAge40to44 + ", femalesSingleAge40to44 " + femalesSingleAge40to44 + ", allPeopleTotalAge45to49 " + allPeopleTotalAge45to49 + ", allPeopleMarriedAge45to49 " + allPeopleMarriedAge45to49 + ", allPeopleSingleAge45to49 " + allPeopleSingleAge45to49 + ", malesTotalAge45to49 " + malesTotalAge45to49 + ", malesMarriedAge45to49 " + malesMarriedAge45to49 + ", malesSingleAge45to49 " + malesSingleAge45to49 + ", femalesTotalAge45to49 " + femalesTotalAge45to49 + ", femalesMarriedAge45to49 " + femalesMarriedAge45to49 + ", femalesSingleAge45to49 " + femalesSingleAge45to49 + ", allPeopleTotalAge50to54 " + allPeopleTotalAge50to54 + ", allPeopleMarriedAge50to54 " + allPeopleMarriedAge50to54 + ", allPeopleSingleAge50to54 " + allPeopleSingleAge50to54 + ", malesTotalAge50to54 " + malesTotalAge50to54 + ", malesMarriedAge50to54 " + malesMarriedAge50to54 + ", malesSingleAge50to54 " + malesSingleAge50to54 + ", femalesTotalAge50to54 " + femalesTotalAge50to54 + ", femalesMarriedAge50to54 " + femalesMarriedAge50to54 + ", femalesSingleAge50to54 " + femalesSingleAge50to54 + ", allPeopleTotalAge55to59 " + allPeopleTotalAge55to59 + ", allPeopleMarriedAge55to59 " + allPeopleMarriedAge55to59 + ", allPeopleSingleAge55to59 " + allPeopleSingleAge55to59 + ", malesTotalAge55to59 " + malesTotalAge55to59 + ", malesMarriedAge55to59 " + malesMarriedAge55to59 + ", malesSingleAge55to59 " + malesSingleAge55to59 + ", femalesTotalAge55to59 " + femalesTotalAge55to59 + ", femalesMarriedAge55to59 " + femalesMarriedAge55to59 + ", femalesSingleAge55to59 " + femalesSingleAge55to59 + ", allPeopleTotalAge65to74 " + allPeopleTotalAge65to74 + ", allPeopleMarriedAge65to74 " + allPeopleMarriedAge65to74 + ", allPeopleSingleAge65to74 " + allPeopleSingleAge65to74 + ", malesTotalAge65to74 " + malesTotalAge65to74 + ", malesMarriedAge65to74 " + malesMarriedAge65to74 + ", malesSingleAge65to74 " + malesSingleAge65to74 + ", femalesTotalAge65to74 " + femalesTotalAge65to74 + ", femalesMarriedAge65to74 " + femalesMarriedAge65to74 + ", femalesSingleAge65to74 " + femalesSingleAge65to74 + ", allPeopleTotalAge75to79 " + allPeopleTotalAge75to79 + ", allPeopleMarriedAge75to79 " + allPeopleMarriedAge75to79 + ", allPeopleSingleAge75to79 " + allPeopleSingleAge75to79 + ", malesTotalAge75to79 " + malesTotalAge75to79 + ", malesMarriedAge75to79 " + malesMarriedAge75to79 + ", malesSingleAge75to79 " + malesSingleAge75to79 + ", femalesTotalAge75to79 " + femalesTotalAge75to79 + ", femalesMarriedAge75to79 " + femalesMarriedAge75to79 + ", femalesSingleAge75to79 " + femalesSingleAge75to79 + ", allPeopleTotalAge80to84 " + allPeopleTotalAge80to84 + ", allPeopleMarriedAge80to84 " + allPeopleMarriedAge80to84 + ", allPeopleSingleAge80to84 " + allPeopleSingleAge80to84 + ", malesTotalAge80to84 " + malesTotalAge80to84 + ", malesMarriedAge80to84 " + malesMarriedAge80to84 + ", malesSingleAge80to84 " + malesSingleAge80to84 + ", femalesTotalAge80to84 " + femalesTotalAge80to84 + ", femalesMarriedAge80to84 " + femalesMarriedAge80to84 + ", femalesSingleAge80to84 " + femalesSingleAge80to84 + ", allPeopleTotalAge85to89 " + allPeopleTotalAge85to89 + ", allPeopleMarriedAge85to89 " + allPeopleMarriedAge85to89 + ", allPeopleSingleAge85to89 " + allPeopleSingleAge85to89 + ", malesTotalAge85to89 " + malesTotalAge85to89 + ", malesMarriedAge85to89 " + malesMarriedAge85to89 + ", malesSingleAge85to89 " + malesSingleAge85to89 + ", femalesTotalAge85to89 " + femalesTotalAge85to89 + ", femalesMarriedAge85to89 " + femalesMarriedAge85to89 + ", femalesSingleAge85to89 " + femalesSingleAge85to89 + ", allPeopleTotalAge90AndOver " + allPeopleTotalAge90AndOver + ", allPeopleMarriedAge90AndOver " + allPeopleMarriedAge90AndOver + ", allPeopleSingleAge90AndOver " + allPeopleSingleAge90AndOver + ", malesTotalAge90AndOver " + malesTotalAge90AndOver + ", malesMarriedAge90AndOver " + malesMarriedAge90AndOver + ", malesSingleAge90AndOver " + malesSingleAge90AndOver + ", femalesTotalAge90AndOver " + femalesTotalAge90AndOver + ", femalesMarriedAge90AndOver " + femalesMarriedAge90AndOver + ", femalesSingleAge90AndOver " + femalesSingleAge90AndOver;
        return string;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the values
     *         of the <code>Fields</code> of <code>this</code>.
     */
    @Override
    public String toCSVString() {
        String result = super.toCSVString();
        result += "," + this.allPeopleTotal;
        result += "," + this.allPeopleMarried;
        result += "," + this.allPeopleSingle;
        result += "," + this.malesTotal;
        result += "," + this.malesMarried;
        result += "," + this.malesSingle;
        result += "," + this.femalesTotal;
        result += "," + this.femalesMarried;
        result += "," + this.femalesSingle;
        result += "," + this.allPeopleTotalAge0to15;
        result += "," + this.allPeopleMarriedAge0to15;
        result += "," + this.allPeopleSingleAge0to15;
        result += "," + this.malesTotalAge0to15;
        result += "," + this.malesMarriedAge0to15;
        result += "," + this.malesSingleAge0to15;
        result += "," + this.femalesTotalAge0to15;
        result += "," + this.femalesMarriedAge0to15;
        result += "," + this.femalesSingleAge0to15;
        result += "," + this.allPeopleTotalAge16to19;
        result += "," + this.allPeopleMarriedAge16to19;
        result += "," + this.allPeopleSingleAge16to19;
        result += "," + this.malesTotalAge16to19;
        result += "," + this.malesMarriedAge16to19;
        result += "," + this.malesSingleAge16to19;
        result += "," + this.femalesTotalAge16to19;
        result += "," + this.femalesMarriedAge16to19;
        result += "," + this.femalesSingleAge16to19;
        result += "," + this.allPeopleTotalAge20to24;
        result += "," + this.allPeopleMarriedAge20to24;
        result += "," + this.allPeopleSingleAge20to24;
        result += "," + this.malesTotalAge20to24;
        result += "," + this.malesMarriedAge20to24;
        result += "," + this.malesSingleAge20to24;
        result += "," + this.femalesTotalAge20to24;
        result += "," + this.femalesMarriedAge20to24;
        result += "," + this.femalesSingleAge20to24;
        result += "," + this.allPeopleTotalAge25to29;
        result += "," + this.allPeopleMarriedAge25to29;
        result += "," + this.allPeopleSingleAge25to29;
        result += "," + this.malesTotalAge25to29;
        result += "," + this.malesMarriedAge25to29;
        result += "," + this.malesSingleAge25to29;
        result += "," + this.femalesTotalAge25to29;
        result += "," + this.femalesMarriedAge25to29;
        result += "," + this.femalesSingleAge25to29;
        result += "," + this.allPeopleTotalAge30to34;
        result += "," + this.allPeopleMarriedAge30to34;
        result += "," + this.allPeopleSingleAge30to34;
        result += "," + this.malesTotalAge30to34;
        result += "," + this.malesMarriedAge30to34;
        result += "," + this.malesSingleAge30to34;
        result += "," + this.femalesTotalAge30to34;
        result += "," + this.femalesMarriedAge30to34;
        result += "," + this.femalesSingleAge30to34;
        result += "," + this.allPeopleTotalAge35to39;
        result += "," + this.allPeopleMarriedAge35to39;
        result += "," + this.allPeopleSingleAge35to39;
        result += "," + this.malesTotalAge35to39;
        result += "," + this.malesMarriedAge35to39;
        result += "," + this.malesSingleAge35to39;
        result += "," + this.femalesTotalAge35to39;
        result += "," + this.femalesMarriedAge35to39;
        result += "," + this.femalesSingleAge35to39;
        result += "," + this.allPeopleTotalAge40to44;
        result += "," + this.allPeopleMarriedAge40to44;
        result += "," + this.allPeopleSingleAge40to44;
        result += "," + this.malesTotalAge40to44;
        result += "," + this.malesMarriedAge40to44;
        result += "," + this.malesSingleAge40to44;
        result += "," + this.femalesTotalAge40to44;
        result += "," + this.femalesMarriedAge40to44;
        result += "," + this.femalesSingleAge40to44;
        result += "," + this.allPeopleTotalAge45to49;
        result += "," + this.allPeopleMarriedAge45to49;
        result += "," + this.allPeopleSingleAge45to49;
        result += "," + this.malesTotalAge45to49;
        result += "," + this.malesMarriedAge45to49;
        result += "," + this.malesSingleAge45to49;
        result += "," + this.femalesTotalAge45to49;
        result += "," + this.femalesMarriedAge45to49;
        result += "," + this.femalesSingleAge45to49;
        result += "," + this.allPeopleTotalAge50to54;
        result += "," + this.allPeopleMarriedAge50to54;
        result += "," + this.allPeopleSingleAge50to54;
        result += "," + this.malesTotalAge50to54;
        result += "," + this.malesMarriedAge50to54;
        result += "," + this.malesSingleAge50to54;
        result += "," + this.femalesTotalAge50to54;
        result += "," + this.femalesMarriedAge50to54;
        result += "," + this.femalesSingleAge50to54;
        result += "," + this.allPeopleTotalAge55to59;
        result += "," + this.allPeopleMarriedAge55to59;
        result += "," + this.allPeopleSingleAge55to59;
        result += "," + this.malesTotalAge55to59;
        result += "," + this.malesMarriedAge55to59;
        result += "," + this.malesSingleAge55to59;
        result += "," + this.femalesTotalAge55to59;
        result += "," + this.femalesMarriedAge55to59;
        result += "," + this.femalesSingleAge55to59;
        result += "," + this.allPeopleTotalAge60to64;
        result += "," + this.allPeopleMarriedAge60to64;
        result += "," + this.allPeopleSingleAge60to64;
        result += "," + this.malesTotalAge60to64;
        result += "," + this.malesMarriedAge60to64;
        result += "," + this.malesSingleAge60to64;
        result += "," + this.femalesTotalAge60to64;
        result += "," + this.femalesMarriedAge60to64;
        result += "," + this.femalesSingleAge60to64;
        result += "," + this.allPeopleTotalAge65to74;
        result += "," + this.allPeopleMarriedAge65to74;
        result += "," + this.allPeopleSingleAge65to74;
        result += "," + this.malesTotalAge65to74;
        result += "," + this.malesMarriedAge65to74;
        result += "," + this.malesSingleAge65to74;
        result += "," + this.femalesTotalAge65to74;
        result += "," + this.femalesMarriedAge65to74;
        result += "," + this.femalesSingleAge65to74;
        result += "," + this.allPeopleTotalAge75to79;
        result += "," + this.allPeopleMarriedAge75to79;
        result += "," + this.allPeopleSingleAge75to79;
        result += "," + this.malesTotalAge75to79;
        result += "," + this.malesMarriedAge75to79;
        result += "," + this.malesSingleAge75to79;
        result += "," + this.femalesTotalAge75to79;
        result += "," + this.femalesMarriedAge75to79;
        result += "," + this.femalesSingleAge75to79;
        result += "," + this.allPeopleTotalAge80to84;
        result += "," + this.allPeopleMarriedAge80to84;
        result += "," + this.allPeopleSingleAge80to84;
        result += "," + this.malesTotalAge80to84;
        result += "," + this.malesMarriedAge80to84;
        result += "," + this.malesSingleAge80to84;
        result += "," + this.femalesTotalAge80to84;
        result += "," + this.femalesMarriedAge80to84;
        result += "," + this.femalesSingleAge80to84;
        result += "," + this.allPeopleTotalAge85to89;
        result += "," + this.allPeopleMarriedAge85to89;
        result += "," + this.allPeopleSingleAge85to89;
        result += "," + this.malesTotalAge85to89;
        result += "," + this.malesMarriedAge85to89;
        result += "," + this.malesSingleAge85to89;
        result += "," + this.femalesTotalAge85to89;
        result += "," + this.femalesMarriedAge85to89;
        result += "," + this.femalesSingleAge85to89;
        result += "," + this.allPeopleTotalAge90AndOver;
        result += "," + this.allPeopleMarriedAge90AndOver;
        result += "," + this.allPeopleSingleAge90AndOver;
        result += "," + this.malesTotalAge90AndOver;
        result += "," + this.malesMarriedAge90AndOver;
        result += "," + this.malesSingleAge90AndOver;
        result += "," + this.femalesTotalAge90AndOver;
        result += "," + this.femalesMarriedAge90AndOver;
        return result;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the names
     *         of the <code>Fields</code> of <code>this</code>
     */
    @Override
    public String toCSVStringFields() {
        String result = super.toCSVStringFields();
        result += ",allPeopleTotal";
        result += ",allPeopleMarried";
        result += ",allPeopleSingle";
        result += ",malesTotal";
        result += ",malesMarried";
        result += ",malesSingle";
        result += ",femalesTotal";
        result += ",femalesMarried";
        result += ",femalesSingle";
        result += ",allPeopleTotalAge0to15";
        result += ",allPeopleMarriedAge0to15";
        result += ",allPeopleSingleAge0to15";
        result += ",malesTotalAge0to15";
        result += ",malesMarriedAge0to15";
        result += ",malesSingleAge0to15";
        result += ",femalesTotalAge0to15";
        result += ",femalesMarriedAge0to15";
        result += ",femalesSingleAge0to15";
        result += ",allPeopleTotalAge16to19";
        result += ",allPeopleMarriedAge16to19";
        result += ",allPeopleSingleAge16to19";
        result += ",malesTotalAge16to19";
        result += ",malesMarriedAge16to19";
        result += ",malesSingleAge16to19";
        result += ",femalesTotalAge16to19";
        result += ",femalesMarriedAge16to19";
        result += ",femalesSingleAge16to19";
        result += ",allPeopleTotalAge20to24";
        result += ",allPeopleMarriedAge20to24";
        result += ",allPeopleSingleAge20to24";
        result += ",malesTotalAge20to24";
        result += ",malesMarriedAge20to24";
        result += ",malesSingleAge20to24";
        result += ",femalesTotalAge20to24";
        result += ",femalesMarriedAge20to24";
        result += ",femalesSingleAge20to24";
        result += ",allPeopleTotalAge25to29";
        result += ",allPeopleMarriedAge25to29";
        result += ",allPeopleSingleAge25to29";
        result += ",malesTotalAge25to29";
        result += ",malesMarriedAge25to29";
        result += ",malesSingleAge25to29";
        result += ",femalesTotalAge25to29";
        result += ",femalesMarriedAge25to29";
        result += ",femalesSingleAge25to29";
        result += ",allPeopleTotalAge30to34";
        result += ",allPeopleMarriedAge30to34";
        result += ",allPeopleSingleAge30to34";
        result += ",malesTotalAge30to34";
        result += ",malesMarriedAge30to34";
        result += ",malesSingleAge30to34";
        result += ",femalesTotalAge30to34";
        result += ",femalesMarriedAge30to34";
        result += ",femalesSingleAge30to34";
        result += ",allPeopleTotalAge35to39";
        result += ",allPeopleMarriedAge35to39";
        result += ",allPeopleSingleAge35to39";
        result += ",malesTotalAge35to39";
        result += ",malesMarriedAge35to39";
        result += ",malesSingleAge35to39";
        result += ",femalesTotalAge35to39";
        result += ",femalesMarriedAge35to39";
        result += ",femalesSingleAge35to39";
        result += ",allPeopleTotalAge40to44";
        result += ",allPeopleMarriedAge40to44";
        result += ",allPeopleSingleAge40to44";
        result += ",malesTotalAge40to44";
        result += ",malesMarriedAge40to44";
        result += ",malesSingleAge40to44";
        result += ",femalesTotalAge40to44";
        result += ",femalesMarriedAge40to44";
        result += ",femalesSingleAge40to44";
        result += ",allPeopleTotalAge45to49";
        result += ",allPeopleMarriedAge45to49";
        result += ",allPeopleSingleAge45to49";
        result += ",malesTotalAge45to49";
        result += ",malesMarriedAge45to49";
        result += ",malesSingleAge45to49";
        result += ",femalesTotalAge45to49";
        result += ",femalesMarriedAge45to49";
        result += ",femalesSingleAge45to49";
        result += ",allPeopleTotalAge50to54";
        result += ",allPeopleMarriedAge50to54";
        result += ",allPeopleSingleAge50to54";
        result += ",malesTotalAge50to54";
        result += ",malesMarriedAge50to54";
        result += ",malesSingleAge50to54";
        result += ",femalesTotalAge50to54";
        result += ",femalesMarriedAge50to54";
        result += ",femalesSingleAge50to54";
        result += ",allPeopleTotalAge55to59";
        result += ",allPeopleMarriedAge55to59";
        result += ",allPeopleSingleAge55to59";
        result += ",malesTotalAge55to59";
        result += ",malesMarriedAge55to59";
        result += ",malesSingleAge55to59";
        result += ",femalesTotalAge55to59";
        result += ",femalesMarriedAge55to59";
        result += ",femalesSingleAge55to59";
        result += ",allPeopleTotalAge60to64";
        result += ",allPeopleMarriedAge60to64";
        result += ",allPeopleSingleAge60to64";
        result += ",malesTotalAge60to64";
        result += ",malesMarriedAge60to64";
        result += ",malesSingleAge60to64";
        result += ",femalesTotalAge60to64";
        result += ",femalesMarriedAge60to64";
        result += ",femalesSingleAge60to64";
        result += ",allPeopleTotalAge65to74";
        result += ",allPeopleMarriedAge65to74";
        result += ",allPeopleSingleAge65to74";
        result += ",malesTotalAge65to74";
        result += ",malesMarriedAge65to74";
        result += ",malesSingleAge65to74";
        result += ",femalesTotalAge65to74";
        result += ",femalesMarriedAge65to74";
        result += ",femalesSingleAge65to74";
        result += ",allPeopleTotalAge75to79";
        result += ",allPeopleMarriedAge75to79";
        result += ",allPeopleSingleAge75to79";
        result += ",malesTotalAge75to79";
        result += ",malesMarriedAge75to79";
        result += ",malesSingleAge75to79";
        result += ",femalesTotalAge75to79";
        result += ",femalesMarriedAge75to79";
        result += ",femalesSingleAge75to79";
        result += ",allPeopleTotalAge80to84";
        result += ",allPeopleMarriedAge80to84";
        result += ",allPeopleSingleAge80to84";
        result += ",malesTotalAge80to84";
        result += ",malesMarriedAge80to84";
        result += ",malesSingleAge80to84";
        result += ",femalesTotalAge80to84";
        result += ",femalesMarriedAge80to84";
        result += ",femalesSingleAge80to84";
        result += ",allPeopleTotalAge85to89";
        result += ",allPeopleMarriedAge85to89";
        result += ",allPeopleSingleAge85to89";
        result += ",malesTotalAge85to89";
        result += ",malesMarriedAge85to89";
        result += ",malesSingleAge85to89";
        result += ",femalesTotalAge85to89";
        result += ",femalesMarriedAge85to89";
        result += ",femalesSingleAge85to89";
        result += ",allPeopleTotalAge90AndOver";
        result += ",allPeopleMarriedAge90AndOver";
        result += ",allPeopleSingleAge90AndOver";
        result += ",malesTotalAge90AndOver";
        result += ",malesMarriedAge90AndOver";
        result += ",malesSingleAge90AndOver";
        result += ",femalesTotalAge90AndOver";
        result += ",femalesMarriedAge90AndOver";
        return result;
    }

    /**
     * Returns a copy of this.allPeopleTotal
     * @return 
     */
    public int getAllPeopleTotal() {
        return this.allPeopleTotal;
    }

    /**
     * Returns a copy of this.allPeopleMarried
     * @return 
     */
    public int getAllPeopleMarried() {
        return this.allPeopleMarried;
    }

    /**
     * Returns a copy of this.allPeopleSingle
     * @return 
     */
    public int getAllPeopleSingle() {
        return this.allPeopleSingle;
    }

    /**
     * Returns a copy of this.malesTotal
     * @return 
     */
    public int getMalesTotal() {
        return this.malesTotal;
    }

    /**
     * Returns a copy of this.malesMarried
     * @return 
     */
    public int getMalesMarried() {
        return this.malesMarried;
    }

    /**
     * Returns a copy of this.malesSingle
     * @return 
     */
    public int getMalesSingle() {
        return this.malesSingle;
    }

    /**
     * Returns a copy of this.femalesTotal
     * @return 
     */
    public int getFemalesTotal() {
        return this.femalesTotal;
    }

    /**
     * Returns a copy of this.femalesMarried
     * @return 
     */
    public int getFemalesMarried() {
        return this.femalesMarried;
    }

    /**
     * Returns a copy of this.femalesSingle
     * @return 
     */
    public int getFemalesSingle() {
        return this.femalesSingle;
    }

    /**
     * Returns a copy of this.allPeopleTotalAge0to15
     * @return 
     */
    public int getAllPeopleTotalAge0to15() {
        return this.allPeopleTotalAge0to15;
    }

    /**
     * Returns a copy of this.allPeopleMarriedAge0to15
     * @return 
     */
    public int getAllPeopleMarriedAge0to15() {
        return this.allPeopleMarriedAge0to15;
    }

    /**
     * Returns a copy of this.allPeopleSingleAge0to15
     * @return 
     */
    public int getAllPeopleSingleAge0to15() {
        return this.allPeopleSingleAge0to15;
    }

    /**
     * Returns a copy of this.malesTotalAge0to15
     * @return 
     */
    public int getMalesTotalAge0to15() {
        return this.malesTotalAge0to15;
    }

    /**
     * Returns a copy of this.malesMarriedAge0to15
     * @return 
     */
    public int getMalesMarriedAge0to15() {
        return this.malesMarriedAge0to15;
    }

    /**
     * Returns a copy of this.malesSingleAge0to15
     * @return 
     */
    public int getMalesSingleAge0to15() {
        return this.malesSingleAge0to15;
    }

    /**
     * Returns a copy of this.femalesTotalAge0to15
     * @return 
     */
    public int getFemalesTotalAge0to15() {
        return this.femalesTotalAge0to15;
    }

    /**
     * Returns a copy of this.femalesMarriedAge0to15
     * @return 
     */
    public int getFemalesMarriedAge0to15() {
        return this.femalesMarriedAge0to15;
    }

    /**
     * Returns a copy of this.femalesSingleAge0to15
     * @return 
     */
    public int getFemalesSingleAge0to15() {
        return this.femalesSingleAge0to15;
    }

    /**
     * Returns a copy of this.allPeopleTotalAge16to19
     * @return 
     */
    public int getAllPeopleTotalAge16to19() {
        return this.allPeopleTotalAge16to19;
    }

    /**
     * Returns a copy of this.allPeopleMarriedAge16to19
     * @return 
     */
    public int getAllPeopleMarriedAge16to19() {
        return this.allPeopleMarriedAge16to19;
    }

    /**
     * Returns a copy of this.allPeopleSingleAge16to19
     * @return 
     */
    public int getAllPeopleSingleAge16to19() {
        return this.allPeopleSingleAge16to19;
    }

    /**
     * Returns a copy of this.malesTotalAge16to19
     * @return 
     */
    public int getMalesTotalAge16to19() {
        return this.malesTotalAge16to19;
    }

    /**
     * Returns a copy of this.malesMarriedAge16to19
     * @return 
     */
    public int getMalesMarriedAge16to19() {
        return this.malesMarriedAge16to19;
    }

    /**
     * Returns a copy of this.malesSingleAge16to19
     * @return 
     */
    public int getMalesSingleAge16to19() {
        return this.malesSingleAge16to19;
    }

    /**
     * Returns a copy of this.femalesTotalAge16to19
     * @return 
     */
    public int getFemalesTotalAge16to19() {
        return this.femalesTotalAge16to19;
    }

    /**
     * Returns a copy of this.femalesMarriedAge16to19
     * @return 
     */
    public int getFemalesMarriedAge16to19() {
        return this.femalesMarriedAge16to19;
    }

    /**
     * Returns a copy of this.femalesSingleAge16to19
     * @return 
     */
    public int getFemalesSingleAge16to19() {
        return this.femalesSingleAge16to19;
    }

    /**
     * Returns a copy of this.allPeopleTotalAge20to24
     * @return 
     */
    public int getAllPeopleTotalAge20to24() {
        return this.allPeopleTotalAge20to24;
    }

    /**
     * Returns a copy of this.allPeopleMarriedAge20to24
     * @return 
     */
    public int getAllPeopleMarriedAge20to24() {
        return this.allPeopleMarriedAge20to24;
    }

    /**
     * Returns a copy of this.allPeopleSingleAge20to24
     * @return 
     */
    public int getAllPeopleSingleAge20to24() {
        return this.allPeopleSingleAge20to24;
    }

    /**
     * Returns a copy of this.malesTotalAge20to24
     * @return 
     */
    public int getMalesTotalAge20to24() {
        return this.malesTotalAge20to24;
    }

    /**
     * Returns a copy of this.malesMarriedAge20to24
     * @return 
     */
    public int getMalesMarriedAge20to24() {
        return this.malesMarriedAge20to24;
    }

    /**
     * Returns a copy of this.malesSingleAge20to24
     * @return 
     */
    public int getMalesSingleAge20to24() {
        return this.malesSingleAge20to24;
    }

    /**
     * Returns a copy of this.femalesTotalAge20to24
     * @return 
     */
    public int getFemalesTotalAge20to24() {
        return this.femalesTotalAge20to24;
    }

    /**
     * Returns a copy of this.femalesMarriedAge20to24
     * @return 
     */
    public int getFemalesMarriedAge20to24() {
        return this.femalesMarriedAge20to24;
    }

    /**
     * Returns a copy of this.femalesSingleAge20to24
     * @return 
     */
    public int getFemalesSingleAge20to24() {
        return this.femalesSingleAge20to24;
    }

    /**
     * Returns a copy of this.allPeopleTotalAge25to29
     * @return 
     */
    public int getAllPeopleTotalAge25to29() {
        return this.allPeopleTotalAge25to29;
    }

    /**
     * Returns a copy of this.allPeopleMarriedAge25to29
     * @return 
     */
    public int getAllPeopleMarriedAge25to29() {
        return this.allPeopleMarriedAge25to29;
    }

    /**
     * Returns a copy of this.allPeopleSingleAge25to29
     * @return 
     */
    public int getAllPeopleSingleAge25to29() {
        return this.allPeopleSingleAge25to29;
    }

    /**
     * Returns a copy of this.malesTotalAge25to29
     * @return 
     */
    public int getMalesTotalAge25to29() {
        return this.malesTotalAge25to29;
    }

    /**
     * Returns a copy of this.malesMarriedAge25to29
     * @return 
     */
    public int getMalesMarriedAge25to29() {
        return this.malesMarriedAge25to29;
    }

    /**
     * Returns a copy of this.malesSingleAge25to29
     * @return 
     */
    public int getMalesSingleAge25to29() {
        return this.malesSingleAge25to29;
    }

    /**
     * Returns a copy of this.femalesTotalAge25to29
     * @return 
     */
    public int getFemalesTotalAge25to29() {
        return this.femalesTotalAge25to29;
    }

    /**
     * Returns a copy of this.femalesMarriedAge25to29
     * @return 
     */
    public int getFemalesMarriedAge25to29() {
        return this.femalesMarriedAge25to29;
    }

    /**
     * Returns a copy of this.femalesSingleAge25to29
     * @return 
     */
    public int getFemalesSingleAge25to29() {
        return this.femalesSingleAge25to29;
    }

    /**
     * Returns a copy of this.allPeopleTotalAge30to34
     * @return 
     */
    public int getAllPeopleTotalAge30to34() {
        return this.allPeopleTotalAge30to34;
    }

    /**
     * Returns a copy of this.allPeopleMarriedAge30to34
     * @return 
     */
    public int getAllPeopleMarriedAge30to34() {
        return this.allPeopleMarriedAge30to34;
    }

    /**
     * Returns a copy of this.allPeopleSingleAge30to34
     * @return 
     */
    public int getAllPeopleSingleAge30to34() {
        return this.allPeopleSingleAge30to34;
    }

    /**
     * Returns a copy of this.malesTotalAge30to34
     * @return 
     */
    public int getMalesTotalAge30to34() {
        return this.malesTotalAge30to34;
    }

    /**
     * Returns a copy of this.malesMarriedAge30to34
     * @return 
     */
    public int getMalesMarriedAge30to34() {
        return this.malesMarriedAge30to34;
    }

    /**
     * Returns a copy of this.malesSingleAge30to34
     * @return 
     */
    public int getMalesSingleAge30to34() {
        return this.malesSingleAge30to34;
    }

    /**
     * Returns a copy of this.femalesTotalAge30to34
     * @return 
     */
    public int getFemalesTotalAge30to34() {
        return this.femalesTotalAge30to34;
    }

    /**
     * Returns a copy of this.femalesMarriedAge30to34
     * @return 
     */
    public int getFemalesMarriedAge30to34() {
        return this.femalesMarriedAge30to34;
    }

    /**
     * Returns a copy of this.femalesSingleAge30to34
     * @return 
     */
    public int getFemalesSingleAge30to34() {
        return this.femalesSingleAge30to34;
    }

    /**
     * Returns a copy of this.allPeopleTotalAge35to39
     * @return 
     */
    public int getAllPeopleTotalAge35to39() {
        return this.allPeopleTotalAge35to39;
    }

    /**
     * Returns a copy of this.allPeopleMarriedAge35to39
     * @return 
     */
    public int getAllPeopleMarriedAge35to39() {
        return this.allPeopleMarriedAge35to39;
    }

    /**
     * Returns a copy of this.allPeopleSingleAge35to39
     * @return 
     */
    public int getAllPeopleSingleAge35to39() {
        return this.allPeopleSingleAge35to39;
    }

    /**
     * Returns a copy of this.malesTotalAge35to39
     * @return 
     */
    public int getMalesTotalAge35to39() {
        return this.malesTotalAge35to39;
    }

    /**
     * Returns a copy of this.malesMarriedAge35to39
     * @return 
     */
    public int getMalesMarriedAge35to39() {
        return this.malesMarriedAge35to39;
    }

    /**
     * Returns a copy of this.malesSingleAge35to39
     * @return 
     */
    public int getMalesSingleAge35to39() {
        return this.malesSingleAge35to39;
    }

    /**
     * Returns a copy of this.femalesTotalAge35to39
     * @return 
     */
    public int getFemalesTotalAge35to39() {
        return this.femalesTotalAge35to39;
    }

    /**
     * Returns a copy of this.femalesMarriedAge35to39
     * @return 
     */
    public int getFemalesMarriedAge35to39() {
        return this.femalesMarriedAge35to39;
    }

    /**
     * Returns a copy of this.femalesSingleAge35to39
     * @return 
     */
    public int getFemalesSingleAge35to39() {
        return this.femalesSingleAge35to39;
    }

    /**
     * Returns a copy of this.allPeopleTotalAge40to44
     * @return 
     */
    public int getAllPeopleTotalAge40to44() {
        return this.allPeopleTotalAge40to44;
    }

    /**
     * Returns a copy of this.allPeopleMarriedAge40to44
     * @return 
     */
    public int getAllPeopleMarriedAge40to44() {
        return this.allPeopleMarriedAge40to44;
    }

    /**
     * Returns a copy of this.allPeopleSingleAge40to44
     * @return 
     */
    public int getAllPeopleSingleAge40to44() {
        return this.allPeopleSingleAge40to44;
    }

    /**
     * Returns a copy of this.malesTotalAge40to44
     * @return 
     */
    public int getMalesTotalAge40to44() {
        return this.malesTotalAge40to44;
    }

    /**
     * Returns a copy of this.malesMarriedAge40to44
     * @return 
     */
    public int getMalesMarriedAge40to44() {
        return this.malesMarriedAge40to44;
    }

    /**
     * Returns a copy of this.malesSingleAge40to44
     * @return 
     */
    public int getMalesSingleAge40to44() {
        return this.malesSingleAge40to44;
    }

    /**
     * Returns a copy of this.femalesTotalAge40to44
     * @return 
     */
    public int getFemalesTotalAge40to44() {
        return this.femalesTotalAge40to44;
    }

    /**
     * Returns a copy of this.femalesMarriedAge40to44
     * @return 
     */
    public int getFemalesMarriedAge40to44() {
        return this.femalesMarriedAge40to44;
    }

    /**
     * Returns a copy of this.femalesSingleAge40to44
     * @return 
     */
    public int getFemalesSingleAge40to44() {
        return this.femalesSingleAge40to44;
    }

    /**
     * Returns a copy of this.allPeopleTotalAge45to49
     * @return 
     */
    public int getAllPeopleTotalAge45to49() {
        return this.allPeopleTotalAge45to49;
    }

    /**
     * Returns a copy of this.allPeopleMarriedAge45to49
     * @return 
     */
    public int getAllPeopleMarriedAge45to49() {
        return this.allPeopleMarriedAge45to49;
    }

    /**
     * Returns a copy of this.allPeopleSingleAge45to49
     * @return 
     */
    public int getAllPeopleSingleAge45to49() {
        return this.allPeopleSingleAge45to49;
    }

    /**
     * Returns a copy of this.malesTotalAge45to49
     * @return 
     */
    public int getMalesTotalAge45to49() {
        return this.malesTotalAge45to49;
    }

    /**
     * Returns a copy of this.malesMarriedAge45to49
     * @return 
     */
    public int getMalesMarriedAge45to49() {
        return this.malesMarriedAge45to49;
    }

    /**
     * Returns a copy of this.malesSingleAge45to49
     * @return 
     */
    public int getMalesSingleAge45to49() {
        return this.malesSingleAge45to49;
    }

    /**
     * Returns a copy of this.femalesTotalAge45to49
     * @return 
     */
    public int getFemalesTotalAge45to49() {
        return this.femalesTotalAge45to49;
    }

    /**
     * Returns a copy of this.femalesMarriedAge45to49
     * @return 
     */
    public int getFemalesMarriedAge45to49() {
        return this.femalesMarriedAge45to49;
    }

    /**
     * Returns a copy of this.femalesSingleAge45to49
     * @return 
     */
    public int getFemalesSingleAge45to49() {
        return this.femalesSingleAge45to49;
    }

    /**
     * Returns a copy of this.allPeopleTotalAge50to54
     * @return 
     */
    public int getAllPeopleTotalAge50to54() {
        return this.allPeopleTotalAge50to54;
    }

    /**
     * Returns a copy of this.allPeopleMarriedAge50to54
     * @return 
     */
    public int getAllPeopleMarriedAge50to54() {
        return this.allPeopleMarriedAge50to54;
    }

    /**
     * Returns a copy of this.allPeopleSingleAge50to54
     * @return 
     */
    public int getAllPeopleSingleAge50to54() {
        return this.allPeopleSingleAge50to54;
    }

    /**
     * Returns a copy of this.malesTotalAge50to54
     * @return 
     */
    public int getMalesTotalAge50to54() {
        return this.malesTotalAge50to54;
    }

    /**
     * Returns a copy of this.malesMarriedAge50to54
     * @return 
     */
    public int getMalesMarriedAge50to54() {
        return this.malesMarriedAge50to54;
    }

    /**
     * Returns a copy of this.malesSingleAge50to54
     * @return 
     */
    public int getMalesSingleAge50to54() {
        return this.malesSingleAge50to54;
    }

    /**
     * Returns a copy of this.femalesTotalAge50to54
     * @return 
     */
    public int getFemalesTotalAge50to54() {
        return this.femalesTotalAge50to54;
    }

    /**
     * Returns a copy of this.femalesMarriedAge50to54
     * @return 
     */
    public int getFemalesMarriedAge50to54() {
        return this.femalesMarriedAge50to54;
    }

    /**
     * Returns a copy of this.femalesSingleAge50to54
     * @return 
     */
    public int getFemalesSingleAge50to54() {
        return this.femalesSingleAge50to54;
    }

    /**
     * Returns a copy of this.allPeopleTotalAge55to59
     * @return 
     */
    public int getAllPeopleTotalAge55to59() {
        return this.allPeopleTotalAge55to59;
    }

    /**
     * Returns a copy of this.allPeopleMarriedAge55to59
     * @return 
     */
    public int getAllPeopleMarriedAge55to59() {
        return this.allPeopleMarriedAge55to59;
    }

    /**
     * Returns a copy of this.allPeopleSingleAge55to59
     * @return 
     */
    public int getAllPeopleSingleAge55to59() {
        return this.allPeopleSingleAge55to59;
    }

    /**
     * Returns a copy of this.malesTotalAge55to59
     * @return 
     */
    public int getMalesTotalAge55to59() {
        return this.malesTotalAge55to59;
    }

    /**
     * Returns a copy of this.malesMarriedAge55to59
     * @return 
     */
    public int getMalesMarriedAge55to59() {
        return this.malesMarriedAge55to59;
    }

    /**
     * Returns a copy of this.malesSingleAge55to59
     * @return 
     */
    public int getMalesSingleAge55to59() {
        return this.malesSingleAge55to59;
    }

    /**
     * Returns a copy of this.femalesTotalAge55to59
     * @return 
     */
    public int getFemalesTotalAge55to59() {
        return this.femalesTotalAge55to59;
    }

    /**
     * Returns a copy of this.femalesMarriedAge55to59
     * @return 
     */
    public int getFemalesMarriedAge55to59() {
        return this.femalesMarriedAge55to59;
    }

    /**
     * Returns a copy of this.femalesSingleAge55to59
     * @return 
     */
    public int getFemalesSingleAge55to59() {
        return this.femalesSingleAge55to59;
    }

    /**
     * Returns a copy of this.allPeopleTotalAge60to64
     * @return 
     */
    public int getAllPeopleTotalAge60to64() {
        return this.allPeopleTotalAge60to64;
    }

    /**
     * Returns a copy of this.allPeopleMarriedAge60to64
     * @return 
     */
    public int getAllPeopleMarriedAge60to64() {
        return this.allPeopleMarriedAge60to64;
    }

    /**
     * Returns a copy of this.allPeopleSingleAge60to64
     * @return 
     */
    public int getAllPeopleSingleAge60to64() {
        return this.allPeopleSingleAge60to64;
    }

    /**
     * Returns a copy of this.malesTotalAge60to64
     * @return 
     */
    public int getMalesTotalAge60to64() {
        return this.malesTotalAge60to64;
    }

    /**
     * Returns a copy of this.malesMarriedAge60to64
     * @return 
     */
    public int getMalesMarriedAge60to64() {
        return this.malesMarriedAge60to64;
    }

    /**
     * Returns a copy of this.malesSingleAge60to64
     * @return 
     */
    public int getMalesSingleAge60to64() {
        return this.malesSingleAge60to64;
    }

    /**
     * Returns a copy of this.femalesTotalAge60to64
     * @return 
     */
    public int getFemalesTotalAge60to64() {
        return this.femalesTotalAge60to64;
    }

    /**
     * Returns a copy of this.femalesMarriedAge60to64
     * @return 
     */
    public int getFemalesMarriedAge60to64() {
        return this.femalesMarriedAge60to64;
    }

    /**
     * Returns a copy of this.femalesSingleAge60to64
     * @return 
     */
    public int getFemalesSingleAge60to64() {
        return this.femalesSingleAge60to64;
    }

    /**
     * Returns a copy of this.allPeopleTotalAge65to74
     * @return 
     */
    public int getAllPeopleTotalAge65to74() {
        return this.allPeopleTotalAge65to74;
    }

    /**
     * Returns a copy of this.allPeopleMarriedAge65to74
     * @return 
     */
    public int getAllPeopleMarriedAge65to74() {
        return this.allPeopleMarriedAge65to74;
    }

    /**
     * Returns a copy of this.allPeopleSingleAge65to74
     * @return 
     */
    public int getAllPeopleSingleAge65to74() {
        return this.allPeopleSingleAge65to74;
    }

    /**
     * Returns a copy of this.malesTotalAge65to74
     * @return 
     */
    public int getMalesTotalAge65to74() {
        return this.malesTotalAge65to74;
    }

    /**
     * Returns a copy of this.malesMarriedAge65to74
     * @return 
     */
    public int getMalesMarriedAge65to74() {
        return this.malesMarriedAge65to74;
    }

    /**
     * Returns a copy of this.malesSingleAge65to74
     * @return 
     */
    public int getMalesSingleAge65to74() {
        return this.malesSingleAge65to74;
    }

    /**
     * Returns a copy of this.femalesTotalAge65to74
     * @return 
     */
    public int getFemalesTotalAge65to74() {
        return this.femalesTotalAge65to74;
    }

    /**
     * Returns a copy of this.femalesMarriedAge65to74
     * @return 
     */
    public int getFemalesMarriedAge65to74() {
        return this.femalesMarriedAge65to74;
    }

    /**
     * Returns a copy of this.femalesSingleAge65to74
     * @return 
     */
    public int getFemalesSingleAge65to74() {
        return this.femalesSingleAge65to74;
    }

    /**
     * Returns a copy of this.allPeopleTotalAge75to79
     * @return 
     */
    public int getAllPeopleTotalAge75to79() {
        return this.allPeopleTotalAge75to79;
    }

    /**
     * Returns a copy of this.allPeopleMarriedAge75to79
     * @return 
     */
    public int getAllPeopleMarriedAge75to79() {
        return this.allPeopleMarriedAge75to79;
    }

    /**
     * Returns a copy of this.allPeopleSingleAge75to79
     * @return 
     */
    public int getAllPeopleSingleAge75to79() {
        return this.allPeopleSingleAge75to79;
    }

    /**
     * Returns a copy of this.malesTotalAge75to79
     * @return 
     */
    public int getMalesTotalAge75to79() {
        return this.malesTotalAge75to79;
    }

    /**
     * Returns a copy of this.malesMarriedAge75to79
     * @return 
     */
    public int getMalesMarriedAge75to79() {
        return this.malesMarriedAge75to79;
    }

    /**
     * Returns a copy of this.malesSingleAge75to79
     * @return 
     */
    public int getMalesSingleAge75to79() {
        return this.malesSingleAge75to79;
    }

    /**
     * Returns a copy of this.femalesTotalAge75to79
     * @return 
     */
    public int getFemalesTotalAge75to79() {
        return this.femalesTotalAge75to79;
    }

    /**
     * Returns a copy of this.femalesMarriedAge75to79
     * @return 
     */
    public int getFemalesMarriedAge75to79() {
        return this.femalesMarriedAge75to79;
    }

    /**
     * Returns a copy of this.femalesSingleAge75to79
     * @return 
     */
    public int getFemalesSingleAge75to79() {
        return this.femalesSingleAge75to79;
    }

    /**
     * Returns a copy of this.allPeopleTotalAge80to84
     * @return 
     */
    public int getAllPeopleTotalAge80to84() {
        return this.allPeopleTotalAge80to84;
    }

    /**
     * Returns a copy of this.allPeopleMarriedAge80to84
     * @return 
     */
    public int getAllPeopleMarriedAge80to84() {
        return this.allPeopleMarriedAge80to84;
    }

    /**
     * Returns a copy of this.allPeopleSingleAge80to84
     * @return 
     */
    public int getAllPeopleSingleAge80to84() {
        return this.allPeopleSingleAge80to84;
    }

    /**
     * Returns a copy of this.malesTotalAge80to84
     * @return 
     */
    public int getMalesTotalAge80to84() {
        return this.malesTotalAge80to84;
    }

    /**
     * Returns a copy of this.malesMarriedAge80to84
     * @return 
     */
    public int getMalesMarriedAge80to84() {
        return this.malesMarriedAge80to84;
    }

    /**
     * Returns a copy of this.malesSingleAge80to84
     * @return 
     */
    public int getMalesSingleAge80to84() {
        return this.malesSingleAge80to84;
    }

    /**
     * Returns a copy of this.femalesTotalAge80to84
     * @return 
     */
    public int getFemalesTotalAge80to84() {
        return this.femalesTotalAge80to84;
    }

    /**
     * Returns a copy of this.femalesMarriedAge80to84
     * @return 
     */
    public int getFemalesMarriedAge80to84() {
        return this.femalesMarriedAge80to84;
    }

    /**
     * Returns a copy of this.femalesSingleAge80to84
     * @return 
     */
    public int getFemalesSingleAge80to84() {
        return this.femalesSingleAge80to84;
    }

    /**
     * Returns a copy of this.allPeopleTotalAge85to89
     * @return 
     */
    public int getAllPeopleTotalAge85to89() {
        return this.allPeopleTotalAge85to89;
    }

    /**
     * Returns a copy of this.allPeopleMarriedAge85to89
     * @return 
     */
    public int getAllPeopleMarriedAge85to89() {
        return this.allPeopleMarriedAge85to89;
    }

    /**
     * Returns a copy of this.allPeopleSingleAge85to89
     * @return 
     */
    public int getAllPeopleSingleAge85to89() {
        return this.allPeopleSingleAge85to89;
    }

    /**
     * Returns a copy of this.malesTotalAge85to89
     * @return 
     */
    public int getMalesTotalAge85to89() {
        return this.malesTotalAge85to89;
    }

    /**
     * Returns a copy of this.malesMarriedAge85to89
     * @return 
     */
    public int getMalesMarriedAge85to89() {
        return this.malesMarriedAge85to89;
    }

    /**
     * Returns a copy of this.malesSingleAge85to89
     * @return 
     */
    public int getMalesSingleAge85to89() {
        return this.malesSingleAge85to89;
    }

    /**
     * Returns a copy of this.femalesTotalAge85to89
     * @return 
     */
    public int getFemalesTotalAge85to89() {
        return this.femalesTotalAge85to89;
    }

    /**
     * Returns a copy of this.femalesMarriedAge85to89
     * @return 
     */
    public int getFemalesMarriedAge85to89() {
        return this.femalesMarriedAge85to89;
    }

    /**
     * Returns a copy of this.femalesSingleAge85to89
     * @return 
     */
    public int getFemalesSingleAge85to89() {
        return this.femalesSingleAge85to89;
    }

    /**
     * Returns a copy of this.allPeopleTotalAge90AndOver
     * @return 
     */
    public int getAllPeopleTotalAge90AndOver() {
        return this.allPeopleTotalAge90AndOver;
    }

    /**
     * Returns a copy of this.allPeopleMarriedAge90AndOver
     * @return 
     */
    public int getAllPeopleMarriedAge90AndOver() {
        return this.allPeopleMarriedAge90AndOver;
    }

    /**
     * Returns a copy of this.allPeopleSingleAge90AndOver
     * @return 
     */
    public int getAllPeopleSingleAge90AndOver() {
        return this.allPeopleSingleAge90AndOver;
    }

    /**
     * Returns a copy of this.malesTotalAge90AndOver
     * @return 
     */
    public int getMalesTotalAge90AndOver() {
        return this.malesTotalAge90AndOver;
    }

    /**
     * Returns a copy of this.malesMarriedAge90AndOver
     * @return 
     */
    public int getMalesMarriedAge90AndOver() {
        return this.malesMarriedAge90AndOver;
    }

    /**
     * Returns a copy of this.malesSingleAge90AndOver
     * @return 
     */
    public int getMalesSingleAge90AndOver() {
        return this.malesSingleAge90AndOver;
    }

    /**
     * Returns a copy of this.femalesTotalAge90AndOver
     * @return 
     */
    public int getFemalesTotalAge90AndOver() {
        return this.femalesTotalAge90AndOver;
    }

    /**
     * Returns a copy of this.femalesMarriedAge90AndOver
     * @return 
     */
    public int getFemalesMarriedAge90AndOver() {
        return this.femalesMarriedAge90AndOver;
    }

    /**
     * Returns a copy of this.femalesSingleAge90AndOver
     * @return 
     */
    public int getFemalesSingleAge90AndOver() {
        return this.femalesSingleAge90AndOver;
    }

    /**
     * Writes <code>this</code> to <code>aRandomAccessFile</code> at the current
     * position.
     *
     * @param aRandomAccessFile
     *            The <code>RandomAccessFile</code> this is written to.
     */
    @Override
    public void write(
            RandomAccessFile aRandomAccessFile) {
        super.write(aRandomAccessFile);
        write(aRandomAccessFile, true);
    }

    /**
     * Writes <code>this</code> to <code>aRandomAccessFile</code> at the current
     * position.
     *
     * @param aRandomAccessFile
     *            The <code>RandomAccessFile</code> this is written to.
     * @param avoidCallToSuper
     *            If true super.write() is not called
     */
    public void write(
            RandomAccessFile aRandomAccessFile,
            boolean avoidCallToSuper) {
        if (avoidCallToSuper) {
            try {
                aRandomAccessFile.writeInt(this.allPeopleTotal);
                aRandomAccessFile.writeInt(this.allPeopleMarried);
                aRandomAccessFile.writeInt(this.allPeopleSingle);
                aRandomAccessFile.writeInt(this.malesTotal);
                aRandomAccessFile.writeInt(this.malesMarried);
                aRandomAccessFile.writeInt(this.malesSingle);
                aRandomAccessFile.writeInt(this.femalesTotal);
                aRandomAccessFile.writeInt(this.femalesMarried);
                aRandomAccessFile.writeInt(this.femalesSingle);
                aRandomAccessFile.writeInt(this.allPeopleTotalAge0to15);
                aRandomAccessFile.writeInt(this.allPeopleMarriedAge0to15);
                aRandomAccessFile.writeInt(this.allPeopleSingleAge0to15);
                aRandomAccessFile.writeInt(this.malesTotalAge0to15);
                aRandomAccessFile.writeInt(this.malesMarriedAge0to15);
                aRandomAccessFile.writeInt(this.malesSingleAge0to15);
                aRandomAccessFile.writeInt(this.femalesTotalAge0to15);
                aRandomAccessFile.writeInt(this.femalesMarriedAge0to15);
                aRandomAccessFile.writeInt(this.femalesSingleAge0to15);
                aRandomAccessFile.writeInt(this.allPeopleTotalAge16to19);
                aRandomAccessFile.writeInt(this.allPeopleMarriedAge16to19);
                aRandomAccessFile.writeInt(this.allPeopleSingleAge16to19);
                aRandomAccessFile.writeInt(this.malesTotalAge16to19);
                aRandomAccessFile.writeInt(this.malesMarriedAge16to19);
                aRandomAccessFile.writeInt(this.malesSingleAge16to19);
                aRandomAccessFile.writeInt(this.femalesTotalAge16to19);
                aRandomAccessFile.writeInt(this.femalesMarriedAge16to19);
                aRandomAccessFile.writeInt(this.femalesSingleAge16to19);
                aRandomAccessFile.writeInt(this.allPeopleTotalAge20to24);
                aRandomAccessFile.writeInt(this.allPeopleMarriedAge20to24);
                aRandomAccessFile.writeInt(this.allPeopleSingleAge20to24);
                aRandomAccessFile.writeInt(this.malesTotalAge20to24);
                aRandomAccessFile.writeInt(this.malesMarriedAge20to24);
                aRandomAccessFile.writeInt(this.malesSingleAge20to24);
                aRandomAccessFile.writeInt(this.femalesTotalAge20to24);
                aRandomAccessFile.writeInt(this.femalesMarriedAge20to24);
                aRandomAccessFile.writeInt(this.femalesSingleAge20to24);
                aRandomAccessFile.writeInt(this.allPeopleTotalAge25to29);
                aRandomAccessFile.writeInt(this.allPeopleMarriedAge25to29);
                aRandomAccessFile.writeInt(this.allPeopleSingleAge25to29);
                aRandomAccessFile.writeInt(this.malesTotalAge25to29);
                aRandomAccessFile.writeInt(this.malesMarriedAge25to29);
                aRandomAccessFile.writeInt(this.malesSingleAge25to29);
                aRandomAccessFile.writeInt(this.femalesTotalAge25to29);
                aRandomAccessFile.writeInt(this.femalesMarriedAge25to29);
                aRandomAccessFile.writeInt(this.femalesSingleAge25to29);
                aRandomAccessFile.writeInt(this.allPeopleTotalAge30to34);
                aRandomAccessFile.writeInt(this.allPeopleMarriedAge30to34);
                aRandomAccessFile.writeInt(this.allPeopleSingleAge30to34);
                aRandomAccessFile.writeInt(this.malesTotalAge30to34);
                aRandomAccessFile.writeInt(this.malesMarriedAge30to34);
                aRandomAccessFile.writeInt(this.malesSingleAge30to34);
                aRandomAccessFile.writeInt(this.femalesTotalAge30to34);
                aRandomAccessFile.writeInt(this.femalesMarriedAge30to34);
                aRandomAccessFile.writeInt(this.femalesSingleAge30to34);
                aRandomAccessFile.writeInt(this.allPeopleTotalAge35to39);
                aRandomAccessFile.writeInt(this.allPeopleMarriedAge35to39);
                aRandomAccessFile.writeInt(this.allPeopleSingleAge35to39);
                aRandomAccessFile.writeInt(this.malesTotalAge35to39);
                aRandomAccessFile.writeInt(this.malesMarriedAge35to39);
                aRandomAccessFile.writeInt(this.malesSingleAge35to39);
                aRandomAccessFile.writeInt(this.femalesTotalAge35to39);
                aRandomAccessFile.writeInt(this.femalesMarriedAge35to39);
                aRandomAccessFile.writeInt(this.femalesSingleAge35to39);
                aRandomAccessFile.writeInt(this.allPeopleTotalAge40to44);
                aRandomAccessFile.writeInt(this.allPeopleMarriedAge40to44);
                aRandomAccessFile.writeInt(this.allPeopleSingleAge40to44);
                aRandomAccessFile.writeInt(this.malesTotalAge40to44);
                aRandomAccessFile.writeInt(this.malesMarriedAge40to44);
                aRandomAccessFile.writeInt(this.malesSingleAge40to44);
                aRandomAccessFile.writeInt(this.femalesTotalAge40to44);
                aRandomAccessFile.writeInt(this.femalesMarriedAge40to44);
                aRandomAccessFile.writeInt(this.femalesSingleAge40to44);
                aRandomAccessFile.writeInt(this.allPeopleTotalAge45to49);
                aRandomAccessFile.writeInt(this.allPeopleMarriedAge45to49);
                aRandomAccessFile.writeInt(this.allPeopleSingleAge45to49);
                aRandomAccessFile.writeInt(this.malesTotalAge45to49);
                aRandomAccessFile.writeInt(this.malesMarriedAge45to49);
                aRandomAccessFile.writeInt(this.malesSingleAge45to49);
                aRandomAccessFile.writeInt(this.femalesTotalAge45to49);
                aRandomAccessFile.writeInt(this.femalesMarriedAge45to49);
                aRandomAccessFile.writeInt(this.femalesSingleAge45to49);
                aRandomAccessFile.writeInt(this.allPeopleTotalAge50to54);
                aRandomAccessFile.writeInt(this.allPeopleMarriedAge50to54);
                aRandomAccessFile.writeInt(this.allPeopleSingleAge50to54);
                aRandomAccessFile.writeInt(this.malesTotalAge50to54);
                aRandomAccessFile.writeInt(this.malesMarriedAge50to54);
                aRandomAccessFile.writeInt(this.malesSingleAge50to54);
                aRandomAccessFile.writeInt(this.femalesTotalAge50to54);
                aRandomAccessFile.writeInt(this.femalesMarriedAge50to54);
                aRandomAccessFile.writeInt(this.femalesSingleAge50to54);
                aRandomAccessFile.writeInt(this.allPeopleTotalAge55to59);
                aRandomAccessFile.writeInt(this.allPeopleMarriedAge55to59);
                aRandomAccessFile.writeInt(this.allPeopleSingleAge55to59);
                aRandomAccessFile.writeInt(this.malesTotalAge55to59);
                aRandomAccessFile.writeInt(this.malesMarriedAge55to59);
                aRandomAccessFile.writeInt(this.malesSingleAge55to59);
                aRandomAccessFile.writeInt(this.femalesTotalAge55to59);
                aRandomAccessFile.writeInt(this.femalesMarriedAge55to59);
                aRandomAccessFile.writeInt(this.femalesSingleAge55to59);
                aRandomAccessFile.writeInt(this.allPeopleTotalAge60to64);
                aRandomAccessFile.writeInt(this.allPeopleMarriedAge60to64);
                aRandomAccessFile.writeInt(this.allPeopleSingleAge60to64);
                aRandomAccessFile.writeInt(this.malesTotalAge60to64);
                aRandomAccessFile.writeInt(this.malesMarriedAge60to64);
                aRandomAccessFile.writeInt(this.malesSingleAge60to64);
                aRandomAccessFile.writeInt(this.femalesTotalAge60to64);
                aRandomAccessFile.writeInt(this.femalesMarriedAge60to64);
                aRandomAccessFile.writeInt(this.femalesSingleAge60to64);
                aRandomAccessFile.writeInt(this.allPeopleTotalAge65to74);
                aRandomAccessFile.writeInt(this.allPeopleMarriedAge65to74);
                aRandomAccessFile.writeInt(this.allPeopleSingleAge65to74);
                aRandomAccessFile.writeInt(this.malesTotalAge65to74);
                aRandomAccessFile.writeInt(this.malesMarriedAge65to74);
                aRandomAccessFile.writeInt(this.malesSingleAge65to74);
                aRandomAccessFile.writeInt(this.femalesTotalAge65to74);
                aRandomAccessFile.writeInt(this.femalesMarriedAge65to74);
                aRandomAccessFile.writeInt(this.femalesSingleAge65to74);
                aRandomAccessFile.writeInt(this.allPeopleTotalAge75to79);
                aRandomAccessFile.writeInt(this.allPeopleMarriedAge75to79);
                aRandomAccessFile.writeInt(this.allPeopleSingleAge75to79);
                aRandomAccessFile.writeInt(this.malesTotalAge75to79);
                aRandomAccessFile.writeInt(this.malesMarriedAge75to79);
                aRandomAccessFile.writeInt(this.malesSingleAge75to79);
                aRandomAccessFile.writeInt(this.femalesTotalAge75to79);
                aRandomAccessFile.writeInt(this.femalesMarriedAge75to79);
                aRandomAccessFile.writeInt(this.femalesSingleAge75to79);
                aRandomAccessFile.writeInt(this.allPeopleTotalAge80to84);
                aRandomAccessFile.writeInt(this.allPeopleMarriedAge80to84);
                aRandomAccessFile.writeInt(this.allPeopleSingleAge80to84);
                aRandomAccessFile.writeInt(this.malesTotalAge80to84);
                aRandomAccessFile.writeInt(this.malesMarriedAge80to84);
                aRandomAccessFile.writeInt(this.malesSingleAge80to84);
                aRandomAccessFile.writeInt(this.femalesTotalAge80to84);
                aRandomAccessFile.writeInt(this.femalesMarriedAge80to84);
                aRandomAccessFile.writeInt(this.femalesSingleAge80to84);
                aRandomAccessFile.writeInt(this.allPeopleTotalAge85to89);
                aRandomAccessFile.writeInt(this.allPeopleMarriedAge85to89);
                aRandomAccessFile.writeInt(this.allPeopleSingleAge85to89);
                aRandomAccessFile.writeInt(this.malesTotalAge85to89);
                aRandomAccessFile.writeInt(this.malesMarriedAge85to89);
                aRandomAccessFile.writeInt(this.malesSingleAge85to89);
                aRandomAccessFile.writeInt(this.femalesTotalAge85to89);
                aRandomAccessFile.writeInt(this.femalesMarriedAge85to89);
                aRandomAccessFile.writeInt(this.femalesSingleAge85to89);
                aRandomAccessFile.writeInt(this.allPeopleTotalAge90AndOver);
                aRandomAccessFile.writeInt(this.allPeopleMarriedAge90AndOver);
                aRandomAccessFile.writeInt(this.allPeopleSingleAge90AndOver);
                aRandomAccessFile.writeInt(this.malesTotalAge90AndOver);
                aRandomAccessFile.writeInt(this.malesMarriedAge90AndOver);
                aRandomAccessFile.writeInt(this.malesSingleAge90AndOver);
                aRandomAccessFile.writeInt(this.femalesTotalAge90AndOver);
                aRandomAccessFile.writeInt(this.femalesMarriedAge90AndOver);
                aRandomAccessFile.writeInt(this.femalesSingleAge90AndOver);
            } catch (IOException aIOException) {
                System.err.println(aIOException.getLocalizedMessage());
                System.exit(Generic_ErrorAndExceptionHandler.IOException);
            }
        } else {
            write(aRandomAccessFile);
        }
    }

    /**
     * @return An aggregated <code>CAS002DataRecord</code> where:
     *         <code>RecordID = this.RecordID</code>
     *         <code>Zone_Code = this.Zone_Code</code> For aggregating
     *         <code>CAS002DataRecords</code>. User needs to take care in
     *         aggregating to ensure aggregation does not compromise (introduce
     *         error) based on the numbers used (i.e. numbers may not be precise
     *         or have sufficient magnitude).
     * @param aCAS002DataRecord
     *            The <code>CAS002DataRecord</code> to be aggregated with
     *            <code>this</code>.
     */
    public CAS002DataRecord aggregate(CAS002DataRecord aCAS002DataRecord) {
        CAS002DataRecord newCAS002DataRecord = new CAS002DataRecord(
                aCAS002DataRecord);
        newCAS002DataRecord.allPeopleTotal += getAllPeopleTotal();
        newCAS002DataRecord.allPeopleMarried += getAllPeopleMarried();
        newCAS002DataRecord.allPeopleSingle += getAllPeopleSingle();
        newCAS002DataRecord.malesTotal += getMalesTotal();
        newCAS002DataRecord.malesMarried += getMalesMarried();
        newCAS002DataRecord.malesSingle += getMalesSingle();
        newCAS002DataRecord.femalesTotal += getFemalesTotal();
        newCAS002DataRecord.femalesMarried += getFemalesMarried();
        newCAS002DataRecord.femalesSingle += getFemalesSingle();
        newCAS002DataRecord.allPeopleTotalAge0to15 += getAllPeopleTotalAge0to15();
        newCAS002DataRecord.allPeopleMarriedAge0to15 += getAllPeopleMarriedAge0to15();
        newCAS002DataRecord.allPeopleSingleAge0to15 += getAllPeopleSingleAge0to15();
        newCAS002DataRecord.malesTotalAge0to15 += getMalesTotalAge0to15();
        newCAS002DataRecord.malesMarriedAge0to15 += getMalesMarriedAge0to15();
        newCAS002DataRecord.malesSingleAge0to15 += getMalesSingleAge0to15();
        newCAS002DataRecord.femalesTotalAge0to15 += getFemalesTotalAge0to15();
        newCAS002DataRecord.femalesMarriedAge0to15 += getFemalesMarriedAge0to15();
        newCAS002DataRecord.femalesSingleAge0to15 += getFemalesSingleAge0to15();
        newCAS002DataRecord.allPeopleTotalAge16to19 += getAllPeopleTotalAge16to19();
        newCAS002DataRecord.allPeopleMarriedAge16to19 += getAllPeopleMarriedAge16to19();
        newCAS002DataRecord.allPeopleSingleAge16to19 += getAllPeopleSingleAge16to19();
        newCAS002DataRecord.malesTotalAge16to19 += getMalesTotalAge16to19();
        newCAS002DataRecord.malesMarriedAge16to19 += getMalesMarriedAge16to19();
        newCAS002DataRecord.malesSingleAge16to19 += getMalesSingleAge16to19();
        newCAS002DataRecord.femalesTotalAge16to19 += getFemalesTotalAge16to19();
        newCAS002DataRecord.femalesMarriedAge16to19 += getFemalesMarriedAge16to19();
        newCAS002DataRecord.femalesSingleAge16to19 += getFemalesSingleAge16to19();
        newCAS002DataRecord.allPeopleTotalAge20to24 += getAllPeopleTotalAge20to24();
        newCAS002DataRecord.allPeopleMarriedAge20to24 += getAllPeopleMarriedAge20to24();
        newCAS002DataRecord.allPeopleSingleAge20to24 += getAllPeopleSingleAge20to24();
        newCAS002DataRecord.malesTotalAge20to24 += getMalesTotalAge20to24();
        newCAS002DataRecord.malesMarriedAge20to24 += getMalesMarriedAge20to24();
        newCAS002DataRecord.malesSingleAge20to24 += getMalesSingleAge20to24();
        newCAS002DataRecord.femalesTotalAge20to24 += getFemalesTotalAge20to24();
        newCAS002DataRecord.femalesMarriedAge20to24 += getFemalesMarriedAge20to24();
        newCAS002DataRecord.femalesSingleAge20to24 += getFemalesSingleAge20to24();
        newCAS002DataRecord.allPeopleTotalAge25to29 += getAllPeopleTotalAge25to29();
        newCAS002DataRecord.allPeopleMarriedAge25to29 += getAllPeopleMarriedAge25to29();
        newCAS002DataRecord.allPeopleSingleAge25to29 += getAllPeopleSingleAge25to29();
        newCAS002DataRecord.malesTotalAge25to29 += getMalesTotalAge25to29();
        newCAS002DataRecord.malesMarriedAge25to29 += getMalesMarriedAge25to29();
        newCAS002DataRecord.malesSingleAge25to29 += getMalesSingleAge25to29();
        newCAS002DataRecord.femalesTotalAge25to29 += getFemalesTotalAge25to29();
        newCAS002DataRecord.femalesMarriedAge25to29 += getFemalesMarriedAge25to29();
        newCAS002DataRecord.femalesSingleAge25to29 += getFemalesSingleAge25to29();
        newCAS002DataRecord.allPeopleTotalAge30to34 += getAllPeopleTotalAge30to34();
        newCAS002DataRecord.allPeopleMarriedAge30to34 += getAllPeopleMarriedAge30to34();
        newCAS002DataRecord.allPeopleSingleAge30to34 += getAllPeopleSingleAge30to34();
        newCAS002DataRecord.malesTotalAge30to34 += getMalesTotalAge30to34();
        newCAS002DataRecord.malesMarriedAge30to34 += getMalesMarriedAge30to34();
        newCAS002DataRecord.malesSingleAge30to34 += getMalesSingleAge30to34();
        newCAS002DataRecord.femalesTotalAge30to34 += getFemalesTotalAge30to34();
        newCAS002DataRecord.femalesMarriedAge30to34 += getFemalesMarriedAge30to34();
        newCAS002DataRecord.femalesSingleAge30to34 += getFemalesSingleAge30to34();
        newCAS002DataRecord.allPeopleTotalAge35to39 += getAllPeopleTotalAge35to39();
        newCAS002DataRecord.allPeopleMarriedAge35to39 += getAllPeopleMarriedAge35to39();
        newCAS002DataRecord.allPeopleSingleAge35to39 += getAllPeopleSingleAge35to39();
        newCAS002DataRecord.malesTotalAge35to39 += getMalesTotalAge35to39();
        newCAS002DataRecord.malesMarriedAge35to39 += getMalesMarriedAge35to39();
        newCAS002DataRecord.malesSingleAge35to39 += getMalesSingleAge35to39();
        newCAS002DataRecord.femalesTotalAge35to39 += getFemalesTotalAge35to39();
        newCAS002DataRecord.femalesMarriedAge35to39 += getFemalesMarriedAge35to39();
        newCAS002DataRecord.femalesSingleAge35to39 += getFemalesSingleAge35to39();
        newCAS002DataRecord.allPeopleTotalAge40to44 += getAllPeopleTotalAge40to44();
        newCAS002DataRecord.allPeopleMarriedAge40to44 += getAllPeopleMarriedAge40to44();
        newCAS002DataRecord.allPeopleSingleAge40to44 += getAllPeopleSingleAge40to44();
        newCAS002DataRecord.malesTotalAge40to44 += getMalesTotalAge40to44();
        newCAS002DataRecord.malesMarriedAge40to44 += getMalesMarriedAge40to44();
        newCAS002DataRecord.malesSingleAge40to44 += getMalesSingleAge40to44();
        newCAS002DataRecord.femalesTotalAge40to44 += getFemalesTotalAge40to44();
        newCAS002DataRecord.femalesMarriedAge40to44 += getFemalesMarriedAge40to44();
        newCAS002DataRecord.femalesSingleAge40to44 += getFemalesSingleAge40to44();
        newCAS002DataRecord.allPeopleTotalAge45to49 += getAllPeopleTotalAge45to49();
        newCAS002DataRecord.allPeopleMarriedAge45to49 += getAllPeopleMarriedAge45to49();
        newCAS002DataRecord.allPeopleSingleAge45to49 += getAllPeopleSingleAge45to49();
        newCAS002DataRecord.malesTotalAge45to49 += getMalesTotalAge45to49();
        newCAS002DataRecord.malesMarriedAge45to49 += getMalesMarriedAge45to49();
        newCAS002DataRecord.malesSingleAge45to49 += getMalesSingleAge45to49();
        newCAS002DataRecord.femalesTotalAge45to49 += getFemalesTotalAge45to49();
        newCAS002DataRecord.femalesMarriedAge45to49 += getFemalesMarriedAge45to49();
        newCAS002DataRecord.femalesSingleAge45to49 += getFemalesSingleAge45to49();
        newCAS002DataRecord.allPeopleTotalAge50to54 += getAllPeopleTotalAge50to54();
        newCAS002DataRecord.allPeopleMarriedAge50to54 += getAllPeopleMarriedAge50to54();
        newCAS002DataRecord.allPeopleSingleAge50to54 += getAllPeopleSingleAge50to54();
        newCAS002DataRecord.malesTotalAge50to54 += getMalesTotalAge50to54();
        newCAS002DataRecord.malesMarriedAge50to54 += getMalesMarriedAge50to54();
        newCAS002DataRecord.malesSingleAge50to54 += getMalesSingleAge50to54();
        newCAS002DataRecord.femalesTotalAge50to54 += getFemalesTotalAge50to54();
        newCAS002DataRecord.femalesMarriedAge50to54 += getFemalesMarriedAge50to54();
        newCAS002DataRecord.femalesSingleAge50to54 += getFemalesSingleAge50to54();
        newCAS002DataRecord.allPeopleTotalAge55to59 += getAllPeopleTotalAge55to59();
        newCAS002DataRecord.allPeopleMarriedAge55to59 += getAllPeopleMarriedAge55to59();
        newCAS002DataRecord.allPeopleSingleAge55to59 += getAllPeopleSingleAge55to59();
        newCAS002DataRecord.malesTotalAge55to59 += getMalesTotalAge55to59();
        newCAS002DataRecord.malesMarriedAge55to59 += getMalesMarriedAge55to59();
        newCAS002DataRecord.malesSingleAge55to59 += getMalesSingleAge55to59();
        newCAS002DataRecord.femalesTotalAge55to59 += getFemalesTotalAge55to59();
        newCAS002DataRecord.femalesMarriedAge55to59 += getFemalesMarriedAge55to59();
        newCAS002DataRecord.femalesSingleAge55to59 += getFemalesSingleAge55to59();
        newCAS002DataRecord.allPeopleTotalAge60to64 += getAllPeopleTotalAge60to64();
        newCAS002DataRecord.allPeopleMarriedAge60to64 += getAllPeopleMarriedAge60to64();
        newCAS002DataRecord.allPeopleSingleAge60to64 += getAllPeopleSingleAge60to64();
        newCAS002DataRecord.malesTotalAge60to64 += getMalesTotalAge60to64();
        newCAS002DataRecord.malesMarriedAge60to64 += getMalesMarriedAge60to64();
        newCAS002DataRecord.malesSingleAge60to64 += getMalesSingleAge60to64();
        newCAS002DataRecord.femalesTotalAge60to64 += getFemalesTotalAge60to64();
        newCAS002DataRecord.femalesMarriedAge60to64 += getFemalesMarriedAge60to64();
        newCAS002DataRecord.femalesSingleAge60to64 += getFemalesSingleAge60to64();
        newCAS002DataRecord.allPeopleTotalAge65to74 += getAllPeopleTotalAge65to74();
        newCAS002DataRecord.allPeopleMarriedAge65to74 += getAllPeopleMarriedAge65to74();
        newCAS002DataRecord.allPeopleSingleAge65to74 += getAllPeopleSingleAge65to74();
        newCAS002DataRecord.malesTotalAge65to74 += getMalesTotalAge65to74();
        newCAS002DataRecord.malesMarriedAge65to74 += getMalesMarriedAge65to74();
        newCAS002DataRecord.malesSingleAge65to74 += getMalesSingleAge65to74();
        newCAS002DataRecord.femalesTotalAge65to74 += getFemalesTotalAge65to74();
        newCAS002DataRecord.femalesMarriedAge65to74 += getFemalesMarriedAge65to74();
        newCAS002DataRecord.femalesSingleAge65to74 += getFemalesSingleAge65to74();
        newCAS002DataRecord.allPeopleTotalAge75to79 += getAllPeopleTotalAge75to79();
        newCAS002DataRecord.allPeopleMarriedAge75to79 += getAllPeopleMarriedAge75to79();
        newCAS002DataRecord.allPeopleSingleAge75to79 += getAllPeopleSingleAge75to79();
        newCAS002DataRecord.malesTotalAge75to79 += getMalesTotalAge75to79();
        newCAS002DataRecord.malesMarriedAge75to79 += getMalesMarriedAge75to79();
        newCAS002DataRecord.malesSingleAge75to79 += getMalesSingleAge75to79();
        newCAS002DataRecord.femalesTotalAge75to79 += getFemalesTotalAge75to79();
        newCAS002DataRecord.femalesMarriedAge75to79 += getFemalesMarriedAge75to79();
        newCAS002DataRecord.femalesSingleAge75to79 += getFemalesSingleAge75to79();
        newCAS002DataRecord.allPeopleTotalAge80to84 += getAllPeopleTotalAge80to84();
        newCAS002DataRecord.allPeopleMarriedAge80to84 += getAllPeopleMarriedAge80to84();
        newCAS002DataRecord.allPeopleSingleAge80to84 += getAllPeopleSingleAge80to84();
        newCAS002DataRecord.malesTotalAge80to84 += getMalesTotalAge80to84();
        newCAS002DataRecord.malesMarriedAge80to84 += getMalesMarriedAge80to84();
        newCAS002DataRecord.malesSingleAge80to84 += getMalesSingleAge80to84();
        newCAS002DataRecord.femalesTotalAge80to84 += getFemalesTotalAge80to84();
        newCAS002DataRecord.femalesMarriedAge80to84 += getFemalesMarriedAge80to84();
        newCAS002DataRecord.femalesSingleAge80to84 += getFemalesSingleAge80to84();
        newCAS002DataRecord.allPeopleTotalAge85to89 += getAllPeopleTotalAge85to89();
        newCAS002DataRecord.allPeopleMarriedAge85to89 += getAllPeopleMarriedAge85to89();
        newCAS002DataRecord.allPeopleSingleAge85to89 += getAllPeopleSingleAge85to89();
        newCAS002DataRecord.malesTotalAge85to89 += getMalesTotalAge85to89();
        newCAS002DataRecord.malesMarriedAge85to89 += getMalesMarriedAge85to89();
        newCAS002DataRecord.malesSingleAge85to89 += getMalesSingleAge85to89();
        newCAS002DataRecord.femalesTotalAge85to89 += getFemalesTotalAge85to89();
        newCAS002DataRecord.femalesMarriedAge85to89 += getFemalesMarriedAge85to89();
        newCAS002DataRecord.femalesSingleAge85to89 += getFemalesSingleAge85to89();
        newCAS002DataRecord.allPeopleTotalAge90AndOver += getAllPeopleTotalAge90AndOver();
        newCAS002DataRecord.allPeopleMarriedAge90AndOver += getAllPeopleMarriedAge90AndOver();
        newCAS002DataRecord.allPeopleSingleAge90AndOver += getAllPeopleSingleAge90AndOver();
        newCAS002DataRecord.malesTotalAge90AndOver += getMalesTotalAge90AndOver();
        newCAS002DataRecord.malesMarriedAge90AndOver += getMalesMarriedAge90AndOver();
        newCAS002DataRecord.malesSingleAge90AndOver += getMalesSingleAge90AndOver();
        newCAS002DataRecord.femalesTotalAge90AndOver += getFemalesTotalAge90AndOver();
        newCAS002DataRecord.femalesMarriedAge90AndOver += getFemalesMarriedAge90AndOver();
        newCAS002DataRecord.femalesSingleAge90AndOver += getFemalesSingleAge90AndOver();
        return newCAS002DataRecord;
    }

    /**
     * @return An aggregated <code>CAS002DataRecord</code> where:
     *         <code>RecordID = newRecordID</code>
     *         <code>Zone_Code = newZone_Code</code> For aggregating
     *         <code>CAS002DataRecords</code>. User needs to take care in
     *         aggregating to ensure aggregation does not compromise (introduce
     *         error) based on the numbers used (i.e. numbers may not be precise
     *         or have sufficient magnitude).
     * @param aCAS002DataRecord
     *            The <code>CAS002DataRecord</code> to be aggregated with
     *            <code>this</code>.
     * @param newRecordID
     *            The <code>RecordID</code> assigned to result.
     * @param newZone_Code
     *            The <code>Zone_Code</code> assigned to result.
     */
    public CAS002DataRecord aggregate(CAS002DataRecord aCAS002DataRecord,
            long newRecordID, char[] newZone_Code) {
        CAS002DataRecord newCAS002DataRecord = new CAS002DataRecord(this);
        newCAS002DataRecord._RecordID = newRecordID;
        // newCAS002DataRecord.Zone_Code = aCAS002DataRecord.Zone_Code;
        int aZone_CodeID = 0;
        for (int Zone_CodeID = 0; Zone_CodeID < newZone_Code.length; Zone_CodeID++) {
            newCAS002DataRecord.Zone_Code[Zone_CodeID] = newZone_Code[Zone_CodeID];
            aZone_CodeID = Zone_CodeID;
        }
        for (int Zone_CodeID = aZone_CodeID; Zone_CodeID < Zone_Code.length; Zone_CodeID++) {
            newCAS002DataRecord.Zone_Code[Zone_CodeID] = ' ';
        }
        newCAS002DataRecord.allPeopleTotal += getAllPeopleTotal();
        newCAS002DataRecord.allPeopleMarried += getAllPeopleMarried();
        newCAS002DataRecord.allPeopleSingle += getAllPeopleSingle();
        newCAS002DataRecord.malesTotal += getMalesTotal();
        newCAS002DataRecord.malesMarried += getMalesMarried();
        newCAS002DataRecord.malesSingle += getMalesSingle();
        newCAS002DataRecord.femalesTotal += getFemalesTotal();
        newCAS002DataRecord.femalesMarried += getFemalesMarried();
        newCAS002DataRecord.femalesSingle += getFemalesSingle();
        newCAS002DataRecord.allPeopleTotalAge0to15 += getAllPeopleTotalAge0to15();
        newCAS002DataRecord.allPeopleMarriedAge0to15 += getAllPeopleMarriedAge0to15();
        newCAS002DataRecord.allPeopleSingleAge0to15 += getAllPeopleSingleAge0to15();
        newCAS002DataRecord.malesTotalAge0to15 += getMalesTotalAge0to15();
        newCAS002DataRecord.malesMarriedAge0to15 += getMalesMarriedAge0to15();
        newCAS002DataRecord.malesSingleAge0to15 += getMalesSingleAge0to15();
        newCAS002DataRecord.femalesTotalAge0to15 += getFemalesTotalAge0to15();
        newCAS002DataRecord.femalesMarriedAge0to15 += getFemalesMarriedAge0to15();
        newCAS002DataRecord.femalesSingleAge0to15 += getFemalesSingleAge0to15();
        newCAS002DataRecord.allPeopleTotalAge16to19 += getAllPeopleTotalAge16to19();
        newCAS002DataRecord.allPeopleMarriedAge16to19 += getAllPeopleMarriedAge16to19();
        newCAS002DataRecord.allPeopleSingleAge16to19 += getAllPeopleSingleAge16to19();
        newCAS002DataRecord.malesTotalAge16to19 += getMalesTotalAge16to19();
        newCAS002DataRecord.malesMarriedAge16to19 += getMalesMarriedAge16to19();
        newCAS002DataRecord.malesSingleAge16to19 += getMalesSingleAge16to19();
        newCAS002DataRecord.femalesTotalAge16to19 += getFemalesTotalAge16to19();
        newCAS002DataRecord.femalesMarriedAge16to19 += getFemalesMarriedAge16to19();
        newCAS002DataRecord.femalesSingleAge16to19 += getFemalesSingleAge16to19();
        newCAS002DataRecord.allPeopleTotalAge20to24 += getAllPeopleTotalAge20to24();
        newCAS002DataRecord.allPeopleMarriedAge20to24 += getAllPeopleMarriedAge20to24();
        newCAS002DataRecord.allPeopleSingleAge20to24 += getAllPeopleSingleAge20to24();
        newCAS002DataRecord.malesTotalAge20to24 += getMalesTotalAge20to24();
        newCAS002DataRecord.malesMarriedAge20to24 += getMalesMarriedAge20to24();
        newCAS002DataRecord.malesSingleAge20to24 += getMalesSingleAge20to24();
        newCAS002DataRecord.femalesTotalAge20to24 += getFemalesTotalAge20to24();
        newCAS002DataRecord.femalesMarriedAge20to24 += getFemalesMarriedAge20to24();
        newCAS002DataRecord.femalesSingleAge20to24 += getFemalesSingleAge20to24();
        newCAS002DataRecord.allPeopleTotalAge25to29 += getAllPeopleTotalAge25to29();
        newCAS002DataRecord.allPeopleMarriedAge25to29 += getAllPeopleMarriedAge25to29();
        newCAS002DataRecord.allPeopleSingleAge25to29 += getAllPeopleSingleAge25to29();
        newCAS002DataRecord.malesTotalAge25to29 += getMalesTotalAge25to29();
        newCAS002DataRecord.malesMarriedAge25to29 += getMalesMarriedAge25to29();
        newCAS002DataRecord.malesSingleAge25to29 += getMalesSingleAge25to29();
        newCAS002DataRecord.femalesTotalAge25to29 += getFemalesTotalAge25to29();
        newCAS002DataRecord.femalesMarriedAge25to29 += getFemalesMarriedAge25to29();
        newCAS002DataRecord.femalesSingleAge25to29 += getFemalesSingleAge25to29();
        newCAS002DataRecord.allPeopleTotalAge30to34 += getAllPeopleTotalAge30to34();
        newCAS002DataRecord.allPeopleMarriedAge30to34 += getAllPeopleMarriedAge30to34();
        newCAS002DataRecord.allPeopleSingleAge30to34 += getAllPeopleSingleAge30to34();
        newCAS002DataRecord.malesTotalAge30to34 += getMalesTotalAge30to34();
        newCAS002DataRecord.malesMarriedAge30to34 += getMalesMarriedAge30to34();
        newCAS002DataRecord.malesSingleAge30to34 += getMalesSingleAge30to34();
        newCAS002DataRecord.femalesTotalAge30to34 += getFemalesTotalAge30to34();
        newCAS002DataRecord.femalesMarriedAge30to34 += getFemalesMarriedAge30to34();
        newCAS002DataRecord.femalesSingleAge30to34 += getFemalesSingleAge30to34();
        newCAS002DataRecord.allPeopleTotalAge35to39 += getAllPeopleTotalAge35to39();
        newCAS002DataRecord.allPeopleMarriedAge35to39 += getAllPeopleMarriedAge35to39();
        newCAS002DataRecord.allPeopleSingleAge35to39 += getAllPeopleSingleAge35to39();
        newCAS002DataRecord.malesTotalAge35to39 += getMalesTotalAge35to39();
        newCAS002DataRecord.malesMarriedAge35to39 += getMalesMarriedAge35to39();
        newCAS002DataRecord.malesSingleAge35to39 += getMalesSingleAge35to39();
        newCAS002DataRecord.femalesTotalAge35to39 += getFemalesTotalAge35to39();
        newCAS002DataRecord.femalesMarriedAge35to39 += getFemalesMarriedAge35to39();
        newCAS002DataRecord.femalesSingleAge35to39 += getFemalesSingleAge35to39();
        newCAS002DataRecord.allPeopleTotalAge40to44 += getAllPeopleTotalAge40to44();
        newCAS002DataRecord.allPeopleMarriedAge40to44 += getAllPeopleMarriedAge40to44();
        newCAS002DataRecord.allPeopleSingleAge40to44 += getAllPeopleSingleAge40to44();
        newCAS002DataRecord.malesTotalAge40to44 += getMalesTotalAge40to44();
        newCAS002DataRecord.malesMarriedAge40to44 += getMalesMarriedAge40to44();
        newCAS002DataRecord.malesSingleAge40to44 += getMalesSingleAge40to44();
        newCAS002DataRecord.femalesTotalAge40to44 += getFemalesTotalAge40to44();
        newCAS002DataRecord.femalesMarriedAge40to44 += getFemalesMarriedAge40to44();
        newCAS002DataRecord.femalesSingleAge40to44 += getFemalesSingleAge40to44();
        newCAS002DataRecord.allPeopleTotalAge45to49 += getAllPeopleTotalAge45to49();
        newCAS002DataRecord.allPeopleMarriedAge45to49 += getAllPeopleMarriedAge45to49();
        newCAS002DataRecord.allPeopleSingleAge45to49 += getAllPeopleSingleAge45to49();
        newCAS002DataRecord.malesTotalAge45to49 += getMalesTotalAge45to49();
        newCAS002DataRecord.malesMarriedAge45to49 += getMalesMarriedAge45to49();
        newCAS002DataRecord.malesSingleAge45to49 += getMalesSingleAge45to49();
        newCAS002DataRecord.femalesTotalAge45to49 += getFemalesTotalAge45to49();
        newCAS002DataRecord.femalesMarriedAge45to49 += getFemalesMarriedAge45to49();
        newCAS002DataRecord.femalesSingleAge45to49 += getFemalesSingleAge45to49();
        newCAS002DataRecord.allPeopleTotalAge50to54 += getAllPeopleTotalAge50to54();
        newCAS002DataRecord.allPeopleMarriedAge50to54 += getAllPeopleMarriedAge50to54();
        newCAS002DataRecord.allPeopleSingleAge50to54 += getAllPeopleSingleAge50to54();
        newCAS002DataRecord.malesTotalAge50to54 += getMalesTotalAge50to54();
        newCAS002DataRecord.malesMarriedAge50to54 += getMalesMarriedAge50to54();
        newCAS002DataRecord.malesSingleAge50to54 += getMalesSingleAge50to54();
        newCAS002DataRecord.femalesTotalAge50to54 += getFemalesTotalAge50to54();
        newCAS002DataRecord.femalesMarriedAge50to54 += getFemalesMarriedAge50to54();
        newCAS002DataRecord.femalesSingleAge50to54 += getFemalesSingleAge50to54();
        newCAS002DataRecord.allPeopleTotalAge55to59 += getAllPeopleTotalAge55to59();
        newCAS002DataRecord.allPeopleMarriedAge55to59 += getAllPeopleMarriedAge55to59();
        newCAS002DataRecord.allPeopleSingleAge55to59 += getAllPeopleSingleAge55to59();
        newCAS002DataRecord.malesTotalAge55to59 += getMalesTotalAge55to59();
        newCAS002DataRecord.malesMarriedAge55to59 += getMalesMarriedAge55to59();
        newCAS002DataRecord.malesSingleAge55to59 += getMalesSingleAge55to59();
        newCAS002DataRecord.femalesTotalAge55to59 += getFemalesTotalAge55to59();
        newCAS002DataRecord.femalesMarriedAge55to59 += getFemalesMarriedAge55to59();
        newCAS002DataRecord.femalesSingleAge55to59 += getFemalesSingleAge55to59();
        newCAS002DataRecord.allPeopleTotalAge60to64 += getAllPeopleTotalAge60to64();
        newCAS002DataRecord.allPeopleMarriedAge60to64 += getAllPeopleMarriedAge60to64();
        newCAS002DataRecord.allPeopleSingleAge60to64 += getAllPeopleSingleAge60to64();
        newCAS002DataRecord.malesTotalAge60to64 += getMalesTotalAge60to64();
        newCAS002DataRecord.malesMarriedAge60to64 += getMalesMarriedAge60to64();
        newCAS002DataRecord.malesSingleAge60to64 += getMalesSingleAge60to64();
        newCAS002DataRecord.femalesTotalAge60to64 += getFemalesTotalAge60to64();
        newCAS002DataRecord.femalesMarriedAge60to64 += getFemalesMarriedAge60to64();
        newCAS002DataRecord.femalesSingleAge60to64 += getFemalesSingleAge60to64();
        newCAS002DataRecord.allPeopleTotalAge65to74 += getAllPeopleTotalAge65to74();
        newCAS002DataRecord.allPeopleMarriedAge65to74 += getAllPeopleMarriedAge65to74();
        newCAS002DataRecord.allPeopleSingleAge65to74 += getAllPeopleSingleAge65to74();
        newCAS002DataRecord.malesTotalAge65to74 += getMalesTotalAge65to74();
        newCAS002DataRecord.malesMarriedAge65to74 += getMalesMarriedAge65to74();
        newCAS002DataRecord.malesSingleAge65to74 += getMalesSingleAge65to74();
        newCAS002DataRecord.femalesTotalAge65to74 += getFemalesTotalAge65to74();
        newCAS002DataRecord.femalesMarriedAge65to74 += getFemalesMarriedAge65to74();
        newCAS002DataRecord.femalesSingleAge65to74 += getFemalesSingleAge65to74();
        newCAS002DataRecord.allPeopleTotalAge75to79 += getAllPeopleTotalAge75to79();
        newCAS002DataRecord.allPeopleMarriedAge75to79 += getAllPeopleMarriedAge75to79();
        newCAS002DataRecord.allPeopleSingleAge75to79 += getAllPeopleSingleAge75to79();
        newCAS002DataRecord.malesTotalAge75to79 += getMalesTotalAge75to79();
        newCAS002DataRecord.malesMarriedAge75to79 += getMalesMarriedAge75to79();
        newCAS002DataRecord.malesSingleAge75to79 += getMalesSingleAge75to79();
        newCAS002DataRecord.femalesTotalAge75to79 += getFemalesTotalAge75to79();
        newCAS002DataRecord.femalesMarriedAge75to79 += getFemalesMarriedAge75to79();
        newCAS002DataRecord.femalesSingleAge75to79 += getFemalesSingleAge75to79();
        newCAS002DataRecord.allPeopleTotalAge80to84 += getAllPeopleTotalAge80to84();
        newCAS002DataRecord.allPeopleMarriedAge80to84 += getAllPeopleMarriedAge80to84();
        newCAS002DataRecord.allPeopleSingleAge80to84 += getAllPeopleSingleAge80to84();
        newCAS002DataRecord.malesTotalAge80to84 += getMalesTotalAge80to84();
        newCAS002DataRecord.malesMarriedAge80to84 += getMalesMarriedAge80to84();
        newCAS002DataRecord.malesSingleAge80to84 += getMalesSingleAge80to84();
        newCAS002DataRecord.femalesTotalAge80to84 += getFemalesTotalAge80to84();
        newCAS002DataRecord.femalesMarriedAge80to84 += getFemalesMarriedAge80to84();
        newCAS002DataRecord.femalesSingleAge80to84 += getFemalesSingleAge80to84();
        newCAS002DataRecord.allPeopleTotalAge85to89 += getAllPeopleTotalAge85to89();
        newCAS002DataRecord.allPeopleMarriedAge85to89 += getAllPeopleMarriedAge85to89();
        newCAS002DataRecord.allPeopleSingleAge85to89 += getAllPeopleSingleAge85to89();
        newCAS002DataRecord.malesTotalAge85to89 += getMalesTotalAge85to89();
        newCAS002DataRecord.malesMarriedAge85to89 += getMalesMarriedAge85to89();
        newCAS002DataRecord.malesSingleAge85to89 += getMalesSingleAge85to89();
        newCAS002DataRecord.femalesTotalAge85to89 += getFemalesTotalAge85to89();
        newCAS002DataRecord.femalesMarriedAge85to89 += getFemalesMarriedAge85to89();
        newCAS002DataRecord.femalesSingleAge85to89 += getFemalesSingleAge85to89();
        newCAS002DataRecord.allPeopleTotalAge90AndOver += getAllPeopleTotalAge90AndOver();
        newCAS002DataRecord.allPeopleMarriedAge90AndOver += getAllPeopleMarriedAge90AndOver();
        newCAS002DataRecord.allPeopleSingleAge90AndOver += getAllPeopleSingleAge90AndOver();
        newCAS002DataRecord.malesTotalAge90AndOver += getMalesTotalAge90AndOver();
        newCAS002DataRecord.malesMarriedAge90AndOver += getMalesMarriedAge90AndOver();
        newCAS002DataRecord.malesSingleAge90AndOver += getMalesSingleAge90AndOver();
        newCAS002DataRecord.femalesTotalAge90AndOver += getFemalesTotalAge90AndOver();
        newCAS002DataRecord.femalesMarriedAge90AndOver += getFemalesMarriedAge90AndOver();
        newCAS002DataRecord.femalesSingleAge90AndOver += getFemalesSingleAge90AndOver();
        return newCAS002DataRecord;
    }

    /**
     * Returns the size of this CAS002DataRecord in bytes as a long. This does
     * not account for serialVersionUID. A boolean is assumed to be the same
     * size as an int in bytes.
     * @return 
     */
    public long getSizeInBytes() {
        long result = super.getSizeInBytes();
        result += (153L * (long) Integer.SIZE) / getNumberOfBitsInByte();
        return result;
    }
}