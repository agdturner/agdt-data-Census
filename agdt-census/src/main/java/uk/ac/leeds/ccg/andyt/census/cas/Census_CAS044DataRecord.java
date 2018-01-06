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
package uk.ac.leeds.ccg.andyt.census.cas;

import uk.ac.leeds.ccg.andyt.census.core.Census_AbstractDataRecord;
import java.io.IOException;
import java.io.RandomAccessFile;
import uk.ac.leeds.ccg.andyt.generic.core.Generic_ErrorAndExceptionHandler;
import uk.ac.leeds.ccg.andyt.census.core.StaticConverter;

/**
 * A <code>class</code> for representing a CAS044 Data Record and providing safe
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
 * @version 1.0.0, 2007-05-24
 * @see CAS044DataHandler
 */
public class Census_CAS044DataRecord extends Census_AbstractDataRecord {

    /*
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Only the first column of this table All HRPs for each NS-SeC are taken
     * care of, i.e. the following cells: CS0440001 ALL HRPs CS0440012 Higher
     * managerial and professional occupations CS0440023 Lower managerial &
     * professional occupations CS0440034 Intermediate occupations CS0440045
     * Small employers & own account workers CS0440056 Lower supervisory and
     * technical occupations CS0440067 Semi-routine occupations CS0440078
     * Routine occupations CS0440089 Never worked or long-term unemployed
     * CS0440100 Not classified
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Table CS044 NS-SeC of Household Reference Person (HRP) by Household
     * Composition: All HRPs Aged 16 to 74 NB: This table contains counts of
     * Persons Users are recommended to review table footnotes and comments for
     * supplementary information relating to individual tables.
     */
    /**
     * CS0440001 = _AllHRPs
     */
    protected int _AllHRPs;
    /**
     * CS0440012 = _HRP_HigherManagerialAndProfessionalOccupations
     */
    protected int _HRP_HigherManagerialAndProfessionalOccupations;
    /**
     * CS0440023 = _HRP_LowerManagerialAndProfessionalOccupations
     */
    protected int _HRP_LowerManagerialAndProfessionalOccupations;
    /**
     * CS0440034 = _HRP_IntermediateOccupations
     */
    protected int _HRP_IntermediateOccupations;
    /**
     * CS0440045 = _HRP_SmallEmployersAndOwnAccountWorkers
     */
    protected int _HRP_SmallEmployersAndOwnAccountWorkers;
    /**
     * CS0440056 = _HRP_LowerSupervisoryAndTechnicalOccupations
     */
    protected int _HRP_LowerSupervisoryAndTechnicalOccupations;
    /**
     * CS0440067 = _HRP_SemiRoutineOccupations
     */
    protected int _HRP_SemiRoutineOccupations;
    /**
     * CS0440078 = _HRP_RoutineOccupations
     */
    protected int _HRP_RoutineOccupations;
    /**
     * CS0440089 = _HRP_NeverWorkedOrLongTermUnemployed
     */
    protected int _HRP_NeverWorkedOrLongTermUnemployed;
    /**
     * CS0440100 = _HRP_NotClassified
     */
    protected int _HRP_NotClassified;

    /** Creates a new CAS044Record */
    public Census_CAS044DataRecord() {
        init();
    }

    /**
     * Creates a new CAS044Record cloned from CAS044Record
     *
     * @param CAS044Record
     *            The CAS044Record from which this is cloned.
     */
    public Census_CAS044DataRecord(Census_CAS044DataRecord CAS044Record) {
        init(CAS044Record);
    }

    /**
     * Creates a new CAS044Record
     *
     * @param initZero
     *            To ensure initZero() is used instead of init()
     */
    public Census_CAS044DataRecord(boolean initZero) {
        initZero();
    }

    /**
     * Creates a new CAS044DataRecord
     *
     * @param RecordID
     *            The RecordID to be assigned to this
     * @param line
     *            The Comma Seperated Value <code>String</code>
     * @throws java.io.IOException
     */
    public Census_CAS044DataRecord(long RecordID, String line) throws IOException {
        String[] fieldsDummy = line.split(",");
        // System.out.println(fieldsDummy.length);
        // for (int i = 0; i < fieldsDummy.length; i ++ ){
        // System.out.println(fieldsDummy[i]);
        // }
        String[] fields = new String[110];
        for (int i = 0; i < fields.length; i++) {
            fields[i] = "";
        }
        System.arraycopy(fieldsDummy, 0, fields, 0, fields.length);
        this.RecordID = RecordID;
        this.Zone_Code = fields[0].substring(1, 11).toCharArray();
        // From Table CAS044
        _AllHRPs = StaticConverter.to_int(fields[1]);
        _HRP_HigherManagerialAndProfessionalOccupations = StaticConverter.to_int(fields[12]);
        _HRP_LowerManagerialAndProfessionalOccupations = StaticConverter.to_int(fields[23]);
        _HRP_IntermediateOccupations = StaticConverter.to_int(fields[34]);
        _HRP_SmallEmployersAndOwnAccountWorkers = StaticConverter.to_int(fields[45]);
        _HRP_LowerSupervisoryAndTechnicalOccupations = StaticConverter.to_int(fields[56]);
        _HRP_SemiRoutineOccupations = StaticConverter.to_int(fields[67]);
        _HRP_RoutineOccupations = StaticConverter.to_int(fields[78]);
        _HRP_NeverWorkedOrLongTermUnemployed = StaticConverter.to_int(fields[89]);
        _HRP_NotClassified = StaticConverter.to_int(fields[100]);
    }

    /**
     * Creates a new <code>CAS044DataRecord</code> from
     * <code>aRandomAccessFile</code>. The
     * <code>aRandomAccessFile.getFilePointer()</code> changes only as the
     * <code>CAS044DataRecord</code> is read.
     *
     * @param aRandomAccessFile
     *            The <code>RandomAccessFile</code> from which this is created.
     * @throws java.io.IOException
     */
    public Census_CAS044DataRecord(RandomAccessFile aRandomAccessFile)
            throws IOException {
        this.RecordID = aRandomAccessFile.readLong();
        this.Zone_Code = new char[10];
        for (int i = 0; i < this.Zone_Code.length; i++) {
            Zone_Code[i] = aRandomAccessFile.readChar();
        }
        _AllHRPs = aRandomAccessFile.readInt();
        _HRP_HigherManagerialAndProfessionalOccupations = aRandomAccessFile.readInt();
        _HRP_LowerManagerialAndProfessionalOccupations = aRandomAccessFile.readInt();
        _HRP_IntermediateOccupations = aRandomAccessFile.readInt();
        _HRP_SmallEmployersAndOwnAccountWorkers = aRandomAccessFile.readInt();
        _HRP_LowerSupervisoryAndTechnicalOccupations = aRandomAccessFile.readInt();
        _HRP_SemiRoutineOccupations = aRandomAccessFile.readInt();
        _HRP_RoutineOccupations = aRandomAccessFile.readInt();
        _HRP_NeverWorkedOrLongTermUnemployed = aRandomAccessFile.readInt();
        _HRP_NotClassified = aRandomAccessFile.readInt();
    }

    /**
     * Initialises all fields.
     */
    protected void init() {
        super.init();
        _AllHRPs = Integer.MIN_VALUE;
        _HRP_HigherManagerialAndProfessionalOccupations = Integer.MIN_VALUE;
        _HRP_LowerManagerialAndProfessionalOccupations = Integer.MIN_VALUE;
        _HRP_IntermediateOccupations = Integer.MIN_VALUE;
        _HRP_SmallEmployersAndOwnAccountWorkers = Integer.MIN_VALUE;
        _HRP_LowerSupervisoryAndTechnicalOccupations = Integer.MIN_VALUE;
        _HRP_SemiRoutineOccupations = Integer.MIN_VALUE;
        _HRP_RoutineOccupations = Integer.MIN_VALUE;
        _HRP_NeverWorkedOrLongTermUnemployed = Integer.MIN_VALUE;
        _HRP_NotClassified = Integer.MIN_VALUE;
    }

    /**
     * Initialises all fields as zero.
     */
    protected void initZero() {
        super.init();
        _AllHRPs = 0;
        _HRP_HigherManagerialAndProfessionalOccupations = 0;
        _HRP_LowerManagerialAndProfessionalOccupations = 0;
        _HRP_IntermediateOccupations = 0;
        _HRP_SmallEmployersAndOwnAccountWorkers = 0;
        _HRP_LowerSupervisoryAndTechnicalOccupations = 0;
        _HRP_SemiRoutineOccupations = 0;
        _HRP_RoutineOccupations = 0;
        _HRP_NeverWorkedOrLongTermUnemployed = 0;
        _HRP_NotClassified = 0;
    }

    /**
     * Initialises from <code>aCAS044DataRecord</code>.
     *
     * @param aCAS044DataRecord
     *            The <code>Census_CAS044DataRecord</code> used to initialise
     *            <code>this</code>.
     */
    protected void init(Census_CAS044DataRecord aCAS044DataRecord) {
        super.init(aCAS044DataRecord);
        _AllHRPs = aCAS044DataRecord._AllHRPs;
        _HRP_HigherManagerialAndProfessionalOccupations = aCAS044DataRecord._HRP_HigherManagerialAndProfessionalOccupations;
        _HRP_LowerManagerialAndProfessionalOccupations = aCAS044DataRecord._HRP_LowerManagerialAndProfessionalOccupations;
        _HRP_IntermediateOccupations = aCAS044DataRecord._HRP_IntermediateOccupations;
        _HRP_SmallEmployersAndOwnAccountWorkers = aCAS044DataRecord._HRP_SmallEmployersAndOwnAccountWorkers;
        _HRP_LowerSupervisoryAndTechnicalOccupations = aCAS044DataRecord._HRP_LowerSupervisoryAndTechnicalOccupations;
        _HRP_SemiRoutineOccupations = aCAS044DataRecord._HRP_SemiRoutineOccupations;
        _HRP_RoutineOccupations = aCAS044DataRecord._HRP_RoutineOccupations;
        _HRP_NeverWorkedOrLongTermUnemployed = aCAS044DataRecord._HRP_NeverWorkedOrLongTermUnemployed;
        _HRP_NotClassified = aCAS044DataRecord._HRP_NotClassified;
    }

    /**
     * Returns a string description of this;
     * @return 
     */
    public String toString() {
        String string = super.toString() + ", _AllHRPs " + _AllHRPs + ", _HRP_HigherManagerialAndProfessionalOccupations " + _HRP_HigherManagerialAndProfessionalOccupations + ", _HRP_LowerManagerialAndProfessionalOccupations " + _HRP_LowerManagerialAndProfessionalOccupations + ", _HRP_IntermediateOccupations " + _HRP_IntermediateOccupations + ", _HRP_SmallEmployersAndOwnAccountWorkers " + _HRP_SmallEmployersAndOwnAccountWorkers + ", _HRP_LowerSupervisoryAndTechnicalOccupations " + _HRP_LowerSupervisoryAndTechnicalOccupations + ", _HRP_SemiRoutineOccupations " + _HRP_SemiRoutineOccupations + ", _HRP_RoutineOccupations " + _HRP_RoutineOccupations + ", _HRP_NeverWorkedOrLongTermUnemployed " + _HRP_NeverWorkedOrLongTermUnemployed + ", _HRP_NotClassified " + _HRP_NotClassified;
        return string;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the values
     *         of the <code>Fields</code> of <code>this</code>.
     */
    @Override
    public String toCSVString() {
        String result = super.toCSVString();
        result += "," + this._AllHRPs;
        result += "," + this._HRP_HigherManagerialAndProfessionalOccupations;
        result += "," + this._HRP_LowerManagerialAndProfessionalOccupations;
        result += "," + this._HRP_IntermediateOccupations;
        result += "," + this._HRP_SmallEmployersAndOwnAccountWorkers;
        result += "," + this._HRP_LowerSupervisoryAndTechnicalOccupations;
        result += "," + this._HRP_SemiRoutineOccupations;
        result += "," + this._HRP_RoutineOccupations;
        result += "," + this._HRP_NeverWorkedOrLongTermUnemployed;
        result += "," + this._HRP_NotClassified;
        return result;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the names
     *         of the <code>Fields</code> of <code>this</code>
     */
    @Override
    public String toCSVStringFields() {
        String result = super.toCSVStringFields();
        result += ",_AllHRPs";
        result += ",_HRP_HigherManagerialAndProfessionalOccupations";
        result += ",_HRP_LowerManagerialAndProfessionalOccupations";
        result += ",_HRP_IntermediateOccupations";
        result += ",_HRP_SmallEmployersAndOwnAccountWorkers";
        result += ",_HRP_LowerSupervisoryAndTechnicalOccupations";
        result += ",_HRP_SemiRoutineOccupations";
        result += ",_HRP_RoutineOccupations";
        result += ",_HRP_NeverWorkedOrLongTermUnemployed";
        result += ",_HRP_NotClassified";
        return result;
    }

    /**
     * Returns a copy of this._AllHRPs
     * @return 
     */
    public int get_AllHRPs() {
        return this._AllHRPs;
    }

    /**
     * Returns a copy of this._HRP_HigherManagerialAndProfessionalOccupations
     * @return 
     */
    public int get_HRP_HigherManagerialAndProfessionalOccupations() {
        return this._HRP_HigherManagerialAndProfessionalOccupations;
    }

    /**
     * Returns a copy of this._HRP_LowerManagerialAndProfessionalOccupations
     * @return 
     */
    public int get_HRP_LowerManagerialAndProfessionalOccupations() {
        return this._HRP_LowerManagerialAndProfessionalOccupations;
    }

    /**
     * Returns a copy of this._HRP_IntermediateOccupations
     * @return 
     */
    public int get_HRP_IntermediateOccupations() {
        return this._HRP_IntermediateOccupations;
    }

    /**
     * Returns a copy of this._HRP_SmallEmployersAndOwnAccountWorkers
     * @return 
     */
    public int get_HRP_SmallEmployersAndOwnAccountWorkers() {
        return this._HRP_SmallEmployersAndOwnAccountWorkers;
    }

    /**
     * Returns a copy of this._HRP_LowerSupervisoryAndTechnicalOccupations
     * @return 
     */
    public int get_HRP_LowerSupervisoryAndTechnicalOccupations() {
        return this._HRP_LowerSupervisoryAndTechnicalOccupations;
    }

    /**
     * Returns a copy of this._HRP_SemiRoutineOccupations
     * @return 
     */
    public int get_HRP_SemiRoutineOccupations() {
        return this._HRP_SemiRoutineOccupations;
    }

    /**
     * Returns a copy of this._HRP_RoutineOccupations
     * @return 
     */
    public int get_HRP_RoutineOccupations() {
        return this._HRP_RoutineOccupations;
    }

    /**
     * Returns a copy of this._HRP_NeverWorkedOrLongTermUnemployed
     * @return 
     */
    public int get_HRP_NeverWorkedOrLongTermUnemployed() {
        return this._HRP_NeverWorkedOrLongTermUnemployed;
    }

    /**
     * Returns a copy of this._HRP_NotClassified
     * @return 
     */
    public int get_HRP_NotClassified() {
        return this._HRP_NotClassified;
    }

    /**
     * Writes <code>this</code> to <code>aRandomAccessFile</code> at the current
     * position.
     *
     * @param aRandomAccessFile
     *            The <code>RandomAccessFile</code> this is written to.
     */
    @Override
    public void write(RandomAccessFile aRandomAccessFile) {
        super.write(aRandomAccessFile);
        write(
                aRandomAccessFile,
                true);
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
                aRandomAccessFile.writeInt(this._AllHRPs);
                aRandomAccessFile.writeInt(this._HRP_HigherManagerialAndProfessionalOccupations);
                aRandomAccessFile.writeInt(this._HRP_LowerManagerialAndProfessionalOccupations);
                aRandomAccessFile.writeInt(this._HRP_IntermediateOccupations);
                aRandomAccessFile.writeInt(this._HRP_SmallEmployersAndOwnAccountWorkers);
                aRandomAccessFile.writeInt(this._HRP_LowerSupervisoryAndTechnicalOccupations);
                aRandomAccessFile.writeInt(this._HRP_SemiRoutineOccupations);
                aRandomAccessFile.writeInt(this._HRP_RoutineOccupations);
                aRandomAccessFile.writeInt(this._HRP_NeverWorkedOrLongTermUnemployed);
                aRandomAccessFile.writeInt(this._HRP_NotClassified);
            } catch (IOException aIOException) {
                System.err.println(aIOException.getLocalizedMessage());
                System.exit(Generic_ErrorAndExceptionHandler.IOException);
            }
        } else {
            write(aRandomAccessFile);
        }
    }

    /**
     * @return An aggregated <code>Census_CAS044DataRecord</code> where:
     *         <code>RecordID = this.RecordID</code>
     *         <code>Zone_Code = this.Zone_Code</code> For aggregating
     *         <code>CAS044DataRecords</code>. User needs to take care in
     *         aggregating to ensure aggregation does not compromise (introduce
     *         error) based on the numbers used (i.e. numbers may not be precise
     *         or have sufficient magnitude).
     * @param aCAS044DataRecord
     *            The <code>Census_CAS044DataRecord</code> to be aggregated with
     *            <code>this</code>.
     */
    public Census_CAS044DataRecord aggregate(
            Census_CAS044DataRecord aCAS044DataRecord) {
        Census_CAS044DataRecord newCAS044DataRecord = new Census_CAS044DataRecord(
                aCAS044DataRecord);
        newCAS044DataRecord._AllHRPs += get_AllHRPs();
        newCAS044DataRecord._HRP_HigherManagerialAndProfessionalOccupations += get_HRP_HigherManagerialAndProfessionalOccupations();
        newCAS044DataRecord._HRP_LowerManagerialAndProfessionalOccupations += get_HRP_LowerManagerialAndProfessionalOccupations();
        newCAS044DataRecord._HRP_IntermediateOccupations += get_HRP_IntermediateOccupations();
        newCAS044DataRecord._HRP_SmallEmployersAndOwnAccountWorkers += get_HRP_SmallEmployersAndOwnAccountWorkers();
        newCAS044DataRecord._HRP_LowerSupervisoryAndTechnicalOccupations += get_HRP_LowerSupervisoryAndTechnicalOccupations();
        newCAS044DataRecord._HRP_SemiRoutineOccupations += get_HRP_SemiRoutineOccupations();
        newCAS044DataRecord._HRP_RoutineOccupations += get_HRP_RoutineOccupations();
        newCAS044DataRecord._HRP_NeverWorkedOrLongTermUnemployed += get_HRP_NeverWorkedOrLongTermUnemployed();
        newCAS044DataRecord._HRP_NotClassified += get_HRP_NotClassified();
        return newCAS044DataRecord;
    }

    /**
     * @return An aggregated <code>Census_CAS044DataRecord</code> where:
     *         <code>RecordID = newRecordID</code>
     *         <code>Zone_Code = newZone_Code</code> For aggregating
     *         <code>CAS044DataRecords</code>. User needs to take care in
     *         aggregating to ensure aggregation does not compromise (introduce
     *         error) based on the numbers used (i.e. numbers may not be precise
     *         or have sufficient magnitude).
     * @param aCAS044DataRecord
     *            The <code>Census_CAS044DataRecord</code> to be aggregated with
     *            <code>this</code>.
     * @param newRecordID
     *            The <code>RecordID</code> assigned to result.
     * @param newZone_Code
     *            The <code>Zone_Code</code> assigned to result.
     */
    public Census_CAS044DataRecord aggregate(
            Census_CAS044DataRecord aCAS044DataRecord,
            long newRecordID,
            char[] newZone_Code) {
        Census_CAS044DataRecord newCAS044DataRecord = new Census_CAS044DataRecord(this);
        newCAS044DataRecord.RecordID = newRecordID;
        // newCAS044DataRecord.Zone_Code = aCAS044DataRecord.Zone_Code;
        int aZone_CodeID = 0;
        for (int Zone_CodeID = 0; Zone_CodeID < newZone_Code.length; Zone_CodeID++) {
            newCAS044DataRecord.Zone_Code[Zone_CodeID] = newZone_Code[Zone_CodeID];
            aZone_CodeID = Zone_CodeID;
        }
        for (int Zone_CodeID = aZone_CodeID; Zone_CodeID < Zone_Code.length; Zone_CodeID++) {
            newCAS044DataRecord.Zone_Code[Zone_CodeID] = ' ';
        }
        newCAS044DataRecord._AllHRPs += get_AllHRPs();
        newCAS044DataRecord._HRP_HigherManagerialAndProfessionalOccupations += get_HRP_HigherManagerialAndProfessionalOccupations();
        newCAS044DataRecord._HRP_LowerManagerialAndProfessionalOccupations += get_HRP_LowerManagerialAndProfessionalOccupations();
        newCAS044DataRecord._HRP_IntermediateOccupations += get_HRP_IntermediateOccupations();
        newCAS044DataRecord._HRP_SmallEmployersAndOwnAccountWorkers += get_HRP_SmallEmployersAndOwnAccountWorkers();
        newCAS044DataRecord._HRP_LowerSupervisoryAndTechnicalOccupations += get_HRP_LowerSupervisoryAndTechnicalOccupations();
        newCAS044DataRecord._HRP_SemiRoutineOccupations += get_HRP_SemiRoutineOccupations();
        newCAS044DataRecord._HRP_RoutineOccupations += get_HRP_RoutineOccupations();
        newCAS044DataRecord._HRP_NeverWorkedOrLongTermUnemployed += get_HRP_NeverWorkedOrLongTermUnemployed();
        newCAS044DataRecord._HRP_NotClassified += get_HRP_NotClassified();
        return newCAS044DataRecord;
    }

    /**
     * Returns the size of this Census_CAS044DataRecord in bytes as a long. This does
     * not account for serialVersionUID. A boolean is assumed to be the same
     * size as an int in bytes.
     * @return 
     */
    @Override
    public long getSizeInBytes() {
        long result = super.getSizeInBytes();
        result += (10L * (long) Integer.SIZE) / getNumberOfBitsInByte();
        return result;
    }
}