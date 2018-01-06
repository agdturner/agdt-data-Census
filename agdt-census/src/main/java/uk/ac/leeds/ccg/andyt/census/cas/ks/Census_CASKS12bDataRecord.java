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
package uk.ac.leeds.ccg.andyt.census.cas.ks;

import java.io.IOException;
import java.io.RandomAccessFile;
import uk.ac.leeds.ccg.andyt.census.core.Census_AbstractDataRecord;
import uk.ac.leeds.ccg.andyt.generic.core.Generic_ErrorAndExceptionHandler;
import uk.ac.leeds.ccg.andyt.census.core.StaticConverter;

/**
 * For representing CAS KS12b Records and providing safe access to the data.
 */
public class Census_CASKS12bDataRecord extends Census_AbstractDataRecord {

    /*
     * Table KS012b Occupation groups - males: All males aged 16-74 in
     * employment
     */
    /**
     * KS012b0001 = malesAged16to74InEmployment
     */
    protected int malesAged16to74InEmployment;
    /**
     * KS012b0002 =
     * malesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials
     */
    protected int malesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials;
    /**
     * KS012b0003 = malesAged16to74InEmploymentWorkingAsProfessionalOccupations
     */
    protected int malesAged16to74InEmploymentWorkingAsProfessionalOccupations;
    /**
     * KS012b0004 =
     * malesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations
     */
    protected int malesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations;
    /**
     * KS012b0005 =
     * malesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations
     */
    protected int malesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations;
    /**
     * KS012b0006 = malesAged16to74InEmploymentWorkingAsSkilledTradesOccupations
     */
    protected int malesAged16to74InEmploymentWorkingAsSkilledTradesOccupations;
    /**
     * KS012b0007 =
     * malesAged16to74InEmploymentWorkingAsPersonalServiceOccupations
     */
    protected int malesAged16to74InEmploymentWorkingAsPersonalServiceOccupations;
    /**
     * KS012b012b =
     * malesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations
     */
    protected int malesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations;
    /**
     * KS012b0009 =
     * malesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives
     */
    protected int malesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives;
    /**
     * KS012b0010 = malesAged16to74InEmploymentWorkingAsElementaryOccupations
     */
    protected int malesAged16to74InEmploymentWorkingAsElementaryOccupations;

    /** Creates a new CASKS12bRecord */
    public Census_CASKS12bDataRecord() {
        init();
    }

    /**
     * Creates a new CASKS12bRecord cloned from cASKS12bRecord
     *
     * @param cASKS12bRecord
     *            The CASKS12bRecord from which this is cloned.
     */
    public Census_CASKS12bDataRecord(Census_CASKS12bDataRecord cASKS12bRecord) {
        init(cASKS12bRecord);
    }

    /**
     * Creates a new CASKS12bDataRecord
     *
     * @param RecordID
     *            The RecordID to be assigned to this
     * @param line
     *            The Comma Seperated Value <code>String</code>
     * @throws java.io.IOException
     */
    public Census_CASKS12bDataRecord(long RecordID, String line) throws IOException {
        String[] fieldsDummy = line.split(",");
        // System.out.println(fieldsDummy.length);
        // for (int i = 0; i < fieldsDummy.length; i ++ ){
        // System.out.println(fieldsDummy[i]);
        // }
        String[] fields = new String[11];
        for (int i = 0; i < fields.length; i++) {
            fields[i] = "";
        }
        System.arraycopy(fieldsDummy, 0, fields, 0, fields.length);
        this.RecordID = RecordID;
        this.Zone_Code = fields[0].substring(1, 11).toCharArray();
        // From Table KS12b
        this.malesAged16to74InEmployment = StaticConverter.to_int(fields[1]);
        this.malesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials = StaticConverter.to_int(fields[2]);
        this.malesAged16to74InEmploymentWorkingAsProfessionalOccupations = StaticConverter.to_int(fields[3]);
        this.malesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations = StaticConverter.to_int(fields[4]);
        this.malesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations = StaticConverter.to_int(fields[5]);
        this.malesAged16to74InEmploymentWorkingAsSkilledTradesOccupations = StaticConverter.to_int(fields[6]);
        this.malesAged16to74InEmploymentWorkingAsPersonalServiceOccupations = StaticConverter.to_int(fields[7]);
        this.malesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations = StaticConverter.to_int(fields[8]);
        this.malesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives = StaticConverter.to_int(fields[9]);
        this.malesAged16to74InEmploymentWorkingAsElementaryOccupations = StaticConverter.to_int(fields[10]);
    }

    /**
     * Creates a new CASKS12bRecord
     *
     * @param aRandomAccessFile
     * @throws java.io.IOException
     */
    public Census_CASKS12bDataRecord(RandomAccessFile aRandomAccessFile)
            throws IOException {
        try {
            this.RecordID = aRandomAccessFile.readLong();
            this.Zone_Code = new char[10];
            for (int i = 0; i < this.Zone_Code.length; i++) {
                Zone_Code[i] = aRandomAccessFile.readChar();
            }
            this.malesAged16to74InEmployment = aRandomAccessFile.readInt();
            this.malesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials = aRandomAccessFile.readInt();
            this.malesAged16to74InEmploymentWorkingAsProfessionalOccupations = aRandomAccessFile.readInt();
            this.malesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations = aRandomAccessFile.readInt();
            this.malesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations = aRandomAccessFile.readInt();
            this.malesAged16to74InEmploymentWorkingAsSkilledTradesOccupations = aRandomAccessFile.readInt();
            this.malesAged16to74InEmploymentWorkingAsPersonalServiceOccupations = aRandomAccessFile.readInt();
            this.malesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations = aRandomAccessFile.readInt();
            this.malesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives = aRandomAccessFile.readInt();
            this.malesAged16to74InEmploymentWorkingAsElementaryOccupations = aRandomAccessFile.readInt();
        } catch (IOException ioe0) {
            // ioe0.printStackTrace();
            throw ioe0;
        }
    }

    /**
     * Initialises all fields.
     */
    protected void init() {
        super.init();
        this.malesAged16to74InEmployment = Integer.MIN_VALUE;
        this.malesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials = Integer.MIN_VALUE;
        this.malesAged16to74InEmploymentWorkingAsProfessionalOccupations = Integer.MIN_VALUE;
        this.malesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations = Integer.MIN_VALUE;
        this.malesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations = Integer.MIN_VALUE;
        this.malesAged16to74InEmploymentWorkingAsSkilledTradesOccupations = Integer.MIN_VALUE;
        this.malesAged16to74InEmploymentWorkingAsPersonalServiceOccupations = Integer.MIN_VALUE;
        this.malesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations = Integer.MIN_VALUE;
        this.malesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives = Integer.MIN_VALUE;
        this.malesAged16to74InEmploymentWorkingAsElementaryOccupations = Integer.MIN_VALUE;
    }

    /**
     * Initialises all fields from those in cASKS12bRecord.
     *
     * @param cASKS12bRecord
     *            The CASKS12bRecord thats fields are used to initialise this.
     */
    protected void init(Census_CASKS12bDataRecord cASKS12bRecord) {
        super.init(cASKS12bRecord);
        this.malesAged16to74InEmployment = cASKS12bRecord.malesAged16to74InEmployment;
        this.malesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials = cASKS12bRecord.malesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials;
        this.malesAged16to74InEmploymentWorkingAsProfessionalOccupations = cASKS12bRecord.malesAged16to74InEmploymentWorkingAsProfessionalOccupations;
        this.malesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations = cASKS12bRecord.malesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations;
        this.malesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations = cASKS12bRecord.malesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations;
        this.malesAged16to74InEmploymentWorkingAsSkilledTradesOccupations = cASKS12bRecord.malesAged16to74InEmploymentWorkingAsSkilledTradesOccupations;
        this.malesAged16to74InEmploymentWorkingAsPersonalServiceOccupations = cASKS12bRecord.malesAged16to74InEmploymentWorkingAsPersonalServiceOccupations;
        this.malesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations = cASKS12bRecord.malesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations;
        this.malesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives = cASKS12bRecord.malesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives;
        this.malesAged16to74InEmploymentWorkingAsElementaryOccupations = cASKS12bRecord.malesAged16to74InEmploymentWorkingAsElementaryOccupations;
    }

    /**
     * Returns a string description of this;
     * @return 
     */
    public String toString() {
        return super.toString() + ", malesAged16to74InEmployment " + malesAged16to74InEmployment + ", malesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials " + malesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials + ", malesAged16to74InEmploymentWorkingAsProfessionalOccupations " + malesAged16to74InEmploymentWorkingAsProfessionalOccupations + ", malesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations " + malesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations + ", malesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations " + malesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations + ", malesAged16to74InEmploymentWorkingAsSkilledTradesOccupations " + malesAged16to74InEmploymentWorkingAsSkilledTradesOccupations + ", malesAged16to74InEmploymentWorkingAsPersonalServiceOccupations" + malesAged16to74InEmploymentWorkingAsPersonalServiceOccupations + ", malesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations" + malesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations + ", malesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives " + malesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives + ", malesAged16to74InEmploymentWorkingAsElementaryOccupations " + malesAged16to74InEmploymentWorkingAsElementaryOccupations;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the values
     *         of the <code>Fields</code> of <code>this</code>.
     */
    @Override
    public String toCSVString() {
        return super.toCSVString() + "," + malesAged16to74InEmployment + "," + malesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials + "," + malesAged16to74InEmploymentWorkingAsProfessionalOccupations + "," + malesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations + "," + malesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations + "," + malesAged16to74InEmploymentWorkingAsSkilledTradesOccupations + "," + malesAged16to74InEmploymentWorkingAsPersonalServiceOccupations + "," + malesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations + "," + malesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives + "," + malesAged16to74InEmploymentWorkingAsElementaryOccupations;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the names
     *         of the <code>Fields</code> of <code>this</code>
     */
    @Override
    public String toCSVStringFields() {
        return super.toCSVStringFields() + ",malesAged16to74InEmployment" + ",malesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials" + ",malesAged16to74InEmploymentWorkingAsProfessionalOccupations" + ",malesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations" + ",malesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations" + ",malesAged16to74InEmploymentWorkingAsSkilledTradesOccupations" + ",malesAged16to74InEmploymentWorkingAsPersonalServiceOccupations" + ",malesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations" + ",malesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives" + ",malesAged16to74InEmploymentWorkingAsElementaryOccupations";
    }

    /**
     * Returns a copy of this.malesAged16to74InEmployment
     * @return 
     */
    public int getMalesAged16to74InEmployment() {
        return this.malesAged16to74InEmployment;
    }

    /**
     * Returns a copy of
     * this.malesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials
     * @return 
     */
    public int getMalesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials() {
        return this.malesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials;
    }

    /**
     * Returns a copy of
     * this.malesAged16to74InEmploymentWorkingAsProfessionalOccupations
     * @return 
     */
    public int getMalesAged16to74InEmploymentWorkingAsProfessionalOccupations() {
        return this.malesAged16to74InEmploymentWorkingAsProfessionalOccupations;
    }

    /**
     * Returns a copy of this.
     * malesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations
     * @return 
     */
    public int getMalesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations() {
        return this.malesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations;
    }

    /**
     * Returns a copy of this.
     * malesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations
     * @return 
     */
    public int getMalesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations() {
        return this.malesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations;
    }

    /**
     * Returns a copy of
     * this.malesAged16to74InEmploymentWorkingAsSkilledTradesOccupations
     * @return 
     */
    public int getMalesAged16to74InEmploymentWorkingAsSkilledTradesOccupations() {
        return this.malesAged16to74InEmploymentWorkingAsSkilledTradesOccupations;
    }

    /**
     * Returns a copy of
     * this.malesAged16to74InEmploymentWorkingAsPersonalServiceOccupations
     * @return 
     */
    public int getMalesAged16to74InEmploymentWorkingAsPersonalServiceOccupations() {
        return this.malesAged16to74InEmploymentWorkingAsPersonalServiceOccupations;
    }

    /**
     * Returns a copy of this.
     * malesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations
     * @return 
     */
    public int getMalesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations() {
        return this.malesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations;
    }

    /**
     * Returns a copy of this.
     * malesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives
     * @return 
     */
    public int getMalesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives() {
        return this.malesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives;
    }

    /**
     * Returns a copy of
     * this.malesAged16to74InEmploymentWorkingAsElementaryOccupations
     * @return 
     */
    public int getMalesAged16to74InEmploymentWorkingAsElementaryOccupations() {
        return this.malesAged16to74InEmploymentWorkingAsElementaryOccupations;
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
                aRandomAccessFile.writeInt(malesAged16to74InEmployment);
                aRandomAccessFile.writeInt(malesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials);
                aRandomAccessFile.writeInt(malesAged16to74InEmploymentWorkingAsProfessionalOccupations);
                aRandomAccessFile.writeInt(malesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations);
                aRandomAccessFile.writeInt(malesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations);
                aRandomAccessFile.writeInt(malesAged16to74InEmploymentWorkingAsSkilledTradesOccupations);
                aRandomAccessFile.writeInt(malesAged16to74InEmploymentWorkingAsPersonalServiceOccupations);
                aRandomAccessFile.writeInt(malesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations);
                aRandomAccessFile.writeInt(malesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives);
                aRandomAccessFile.writeInt(malesAged16to74InEmploymentWorkingAsElementaryOccupations);
            } catch (IOException aIOException) {
                System.err.println(aIOException.getLocalizedMessage());
                System.exit(Generic_ErrorAndExceptionHandler.IOException);
            }
        } else {
            write(aRandomAccessFile);
        }
    }

    /**
     * @return An aggregated <code>Census_CASKS12bDataRecord</code> where:
     *         <code>RecordID = this.RecordID</code>
     *         <code>Zone_Code = this.Zone_Code</code> For aggregating
     *         <code>CASKS12bDataRecords</code>. User needs to take care in
     *         aggregating to ensure aggregation does not compromise (introduce
     *         error) based on the numbers used (i.e. numbers may not be precise
     *         or have sufficient magnitude).
     * @param aCASKS12bDataRecord
     *            The <code>Census_CASKS12bDataRecord</code> to be aggregated with
     *            <code>this</code>.
     */
    public Census_CASKS12bDataRecord aggregate(Census_CASKS12bDataRecord aCASKS12bDataRecord) {
        Census_CASKS12bDataRecord newCASKS12bDataRecord = new Census_CASKS12bDataRecord(
                aCASKS12bDataRecord);
        newCASKS12bDataRecord.malesAged16to74InEmployment += getMalesAged16to74InEmployment();
        newCASKS12bDataRecord.malesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials += getMalesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials();
        newCASKS12bDataRecord.malesAged16to74InEmploymentWorkingAsProfessionalOccupations += getMalesAged16to74InEmploymentWorkingAsProfessionalOccupations();
        newCASKS12bDataRecord.malesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations += getMalesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations();
        newCASKS12bDataRecord.malesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations += getMalesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations();
        newCASKS12bDataRecord.malesAged16to74InEmploymentWorkingAsSkilledTradesOccupations += getMalesAged16to74InEmploymentWorkingAsSkilledTradesOccupations();
        newCASKS12bDataRecord.malesAged16to74InEmploymentWorkingAsPersonalServiceOccupations = getMalesAged16to74InEmploymentWorkingAsPersonalServiceOccupations();
        newCASKS12bDataRecord.malesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations = getMalesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations();
        newCASKS12bDataRecord.malesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives += getMalesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives();
        newCASKS12bDataRecord.malesAged16to74InEmploymentWorkingAsElementaryOccupations += getMalesAged16to74InEmploymentWorkingAsElementaryOccupations();
        return newCASKS12bDataRecord;
    }

    /**
     * @return An aggregated <code>Census_CASKS12bDataRecord</code> where:
     *         <code>RecordID = newRecordID</code>
     *         <code>Zone_Code = newZone_Code</code> For aggregating
     *         <code>CASKS12bDataRecords</code>. User needs to take care in
     *         aggregating to ensure aggregation does not compromise (introduce
     *         error) based on the numbers used (i.e. numbers may not be precise
     *         or have sufficient magnitude).
     * @param aCASKS12bDataRecord
     *            The <code>Census_CASKS12bDataRecord</code> to be aggregated with
     *            <code>this</code>.
     * @param newRecordID
     *            The <code>RecordID</code> assigned to result.
     * @param newZone_Code
     *            The <code>Zone_Code</code> assigned to result.
     */
    public Census_CASKS12bDataRecord aggregate(Census_CASKS12bDataRecord aCASKS12bDataRecord,
            long newRecordID, char[] newZone_Code) {
        Census_CASKS12bDataRecord newCASKS12bDataRecord = new Census_CASKS12bDataRecord(this);
        newCASKS12bDataRecord.RecordID = newRecordID;
        // newCASKS12bDataRecord.Zone_Code = aCASKS12bDataRecord.Zone_Code;
        int aZone_CodeID = 0;
        for (int Zone_CodeID = 0; Zone_CodeID < newZone_Code.length; Zone_CodeID++) {
            newCASKS12bDataRecord.Zone_Code[Zone_CodeID] = newZone_Code[Zone_CodeID];
            aZone_CodeID = Zone_CodeID;
        }
        for (int Zone_CodeID = aZone_CodeID; Zone_CodeID < Zone_Code.length; Zone_CodeID++) {
            newCASKS12bDataRecord.Zone_Code[Zone_CodeID] = ' ';
        }
        newCASKS12bDataRecord.malesAged16to74InEmployment += getMalesAged16to74InEmployment();
        newCASKS12bDataRecord.malesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials += getMalesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials();
        newCASKS12bDataRecord.malesAged16to74InEmploymentWorkingAsProfessionalOccupations += getMalesAged16to74InEmploymentWorkingAsProfessionalOccupations();
        newCASKS12bDataRecord.malesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations += getMalesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations();
        newCASKS12bDataRecord.malesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations += getMalesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations();
        newCASKS12bDataRecord.malesAged16to74InEmploymentWorkingAsSkilledTradesOccupations += getMalesAged16to74InEmploymentWorkingAsSkilledTradesOccupations();
        newCASKS12bDataRecord.malesAged16to74InEmploymentWorkingAsPersonalServiceOccupations = getMalesAged16to74InEmploymentWorkingAsPersonalServiceOccupations();
        newCASKS12bDataRecord.malesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations = getMalesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations();
        newCASKS12bDataRecord.malesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives += getMalesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives();
        newCASKS12bDataRecord.malesAged16to74InEmploymentWorkingAsElementaryOccupations += getMalesAged16to74InEmploymentWorkingAsElementaryOccupations();
        return newCASKS12bDataRecord;
    }

    /**
     * Returns the size of this CASKS12bRecord in bytes as a long. This does not
     * account for serialVersionUID. A boolean is assumed to be the same size as
     * an int in bytes.
     * @return 
     */
    public long getSizeInBytes() {
        long result = super.getSizeInBytes();
        result += (10L * (long) Integer.SIZE) / getNumberOfBitsInByte();
        return result;
    }
}
