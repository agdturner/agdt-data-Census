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

/**
 * For representing CAS KS12c Records and providing safe access to the data.
 */
public class Census_CASKS12cDataRecord extends Census_AbstractDataRecord {

    /*
     * Table KS012c Occupation groups - females: All females aged 16-74 in
     * employment
     */
    /**
     * KS012c0001 = femalesAged16to74InEmployment
     */
    protected int femalesAged16to74InEmployment;
    /**
     * KS012c0002 =
     * femalesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials
     */
    protected int femalesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials;
    /**
     * KS012c0003 =
     * femalesAged16to74InEmploymentWorkingAsProfessionalOccupations
     */
    protected int femalesAged16to74InEmploymentWorkingAsProfessionalOccupations;
    /**
     * KS012c0004 =femalesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations
     */
    protected int femalesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations;
    /**
     * KS012c0005 =
     * femalesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations
     */
    protected int femalesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations;
    /**
     * KS012c0006 =
     * femalesAged16to74InEmploymentWorkingAsSkilledTradesOccupations
     */
    protected int femalesAged16to74InEmploymentWorkingAsSkilledTradesOccupations;
    /**
     * KS012c0007 =
     * femalesAged16to74InEmploymentWorkingAsPersonalServiceOccupations
     */
    protected int femalesAged16to74InEmploymentWorkingAsPersonalServiceOccupations;
    /**
     * KS012c012c =
     * femalesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations
     */
    protected int femalesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations;
    /**
     * KS012c0009 =
     * femalesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives
     */
    protected int femalesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives;
    /**
     * KS012c0010 = femalesAged16to74InEmploymentWorkingAsElementaryOccupations
     */
    protected int femalesAged16to74InEmploymentWorkingAsElementaryOccupations;

    /** Creates a new CASKS12cRecord */
    public Census_CASKS12cDataRecord() {
        init();
    }

    /**
     * Creates a new CASKS12cRecord cloned from cASKS12cRecord
     *
     * @param cASKS12cRecord
     *            The CASKS12cRecord from which this is cloned.
     */
    public Census_CASKS12cDataRecord(Census_CASKS12cDataRecord cASKS12cRecord) {
        Census_CASKS12cDataRecord.this.init(cASKS12cRecord);
    }

    /**
     * Creates a new CASKS12cDataRecord
     *
     * @param RecordID
     *            The RecordID to be assigned to this
     * @param line
     *            The Comma Seperated Value <code>String</code>
     * @throws java.io.IOException
     */
    public Census_CASKS12cDataRecord(long RecordID, String line) throws IOException {
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
        // From Table KS12c
        this.femalesAged16to74InEmployment = new Integer(fields[1]);
        this.femalesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials = new Integer(fields[2]);
        this.femalesAged16to74InEmploymentWorkingAsProfessionalOccupations = new Integer(fields[3]);
        this.femalesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations = new Integer(fields[4]);
        this.femalesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations = new Integer(fields[5]);
        this.femalesAged16to74InEmploymentWorkingAsSkilledTradesOccupations = new Integer(fields[6]);
        this.femalesAged16to74InEmploymentWorkingAsPersonalServiceOccupations = new Integer(fields[7]);
        this.femalesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations = new Integer(fields[8]);
        this.femalesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives = new Integer(fields[9]);
        this.femalesAged16to74InEmploymentWorkingAsElementaryOccupations = new Integer(fields[10]);
    }

    /**
     * Creates a new CASKS12cRecord
     *
     * @param aRandomAccessFile
     * @throws java.io.IOException
     */
    public Census_CASKS12cDataRecord(RandomAccessFile aRandomAccessFile)
            throws IOException {
        try {
            this.RecordID = aRandomAccessFile.readLong();
            this.Zone_Code = new char[10];
            for (int i = 0; i < this.Zone_Code.length; i++) {
                Zone_Code[i] = aRandomAccessFile.readChar();
            }
            this.femalesAged16to74InEmployment = aRandomAccessFile.readInt();
            this.femalesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials = aRandomAccessFile.readInt();
            this.femalesAged16to74InEmploymentWorkingAsProfessionalOccupations = aRandomAccessFile.readInt();
            this.femalesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations = aRandomAccessFile.readInt();
            this.femalesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations = aRandomAccessFile.readInt();
            this.femalesAged16to74InEmploymentWorkingAsSkilledTradesOccupations = aRandomAccessFile.readInt();
            this.femalesAged16to74InEmploymentWorkingAsPersonalServiceOccupations = aRandomAccessFile.readInt();
            this.femalesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations = aRandomAccessFile.readInt();
            this.femalesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives = aRandomAccessFile.readInt();
            this.femalesAged16to74InEmploymentWorkingAsElementaryOccupations = aRandomAccessFile.readInt();
        } catch (IOException ioe0) {
            // ioe0.printStackTrace();
            throw ioe0;
        }
    }

    /**
     * Initialises all fields.
     */
    @Override
    protected final void init() {
        super.init();
        this.femalesAged16to74InEmployment = Integer.MIN_VALUE;
        this.femalesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials = Integer.MIN_VALUE;
        this.femalesAged16to74InEmploymentWorkingAsProfessionalOccupations = Integer.MIN_VALUE;
        this.femalesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations = Integer.MIN_VALUE;
        this.femalesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations = Integer.MIN_VALUE;
        this.femalesAged16to74InEmploymentWorkingAsSkilledTradesOccupations = Integer.MIN_VALUE;
        this.femalesAged16to74InEmploymentWorkingAsPersonalServiceOccupations = Integer.MIN_VALUE;
        this.femalesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations = Integer.MIN_VALUE;
        this.femalesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives = Integer.MIN_VALUE;
        this.femalesAged16to74InEmploymentWorkingAsElementaryOccupations = Integer.MIN_VALUE;
    }

    /**
     * Initialises all fields from those in cASKS12cRecord.
     *
     * @param cASKS12cRecord
     *            The CASKS12cRecord thats fields are used to initialise this.
     */
    protected void init(Census_CASKS12cDataRecord cASKS12cRecord) {
        super.init(cASKS12cRecord);
        this.femalesAged16to74InEmployment = cASKS12cRecord.femalesAged16to74InEmployment;
        this.femalesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials = cASKS12cRecord.femalesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials;
        this.femalesAged16to74InEmploymentWorkingAsProfessionalOccupations = cASKS12cRecord.femalesAged16to74InEmploymentWorkingAsProfessionalOccupations;
        this.femalesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations = cASKS12cRecord.femalesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations;
        this.femalesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations = cASKS12cRecord.femalesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations;
        this.femalesAged16to74InEmploymentWorkingAsSkilledTradesOccupations = cASKS12cRecord.femalesAged16to74InEmploymentWorkingAsSkilledTradesOccupations;
        this.femalesAged16to74InEmploymentWorkingAsPersonalServiceOccupations = cASKS12cRecord.femalesAged16to74InEmploymentWorkingAsPersonalServiceOccupations;
        this.femalesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations = cASKS12cRecord.femalesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations;
        this.femalesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives = cASKS12cRecord.femalesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives;
        this.femalesAged16to74InEmploymentWorkingAsElementaryOccupations = cASKS12cRecord.femalesAged16to74InEmploymentWorkingAsElementaryOccupations;
    }

    /**
     * Returns a string description of this;
     * @return 
     */
    @Override
    public String toString() {
        return super.toString() +
                ", femalesAged16to74InEmployment " + femalesAged16to74InEmployment +
                ", femalesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials " + femalesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials +
                ", femalesAged16to74InEmploymentWorkingAsProfessionalOccupations " + femalesAged16to74InEmploymentWorkingAsProfessionalOccupations +
                ", femalesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations " + femalesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations +
                ", femalesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations " + femalesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations +
                ", femalesAged16to74InEmploymentWorkingAsSkilledTradesOccupations " + femalesAged16to74InEmploymentWorkingAsSkilledTradesOccupations +
                ", femalesAged16to74InEmploymentWorkingAsPersonalServiceOccupations" + femalesAged16to74InEmploymentWorkingAsPersonalServiceOccupations +
                ", femalesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations" + femalesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations +
                ", femalesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives " + femalesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives +
                ", femalesAged16to74InEmploymentWorkingAsElementaryOccupations " + femalesAged16to74InEmploymentWorkingAsElementaryOccupations;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the values
     *         of the <code>Fields</code> of <code>this</code>.
     */
    @Override
    public String toCSVString() {
        return super.toCSVString() + "," +
                femalesAged16to74InEmployment + "," +
                femalesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials + "," +
                femalesAged16to74InEmploymentWorkingAsProfessionalOccupations + "," +
                femalesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations + "," +
                femalesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations + "," +
                femalesAged16to74InEmploymentWorkingAsSkilledTradesOccupations + "," +
                femalesAged16to74InEmploymentWorkingAsPersonalServiceOccupations + "," +
                femalesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations + "," +
                femalesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives + "," +
                femalesAged16to74InEmploymentWorkingAsElementaryOccupations;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the names
     *         of the <code>Fields</code> of <code>this</code>
     */
    @Override
    public String toCSVStringFields() {
        return super.toCSVStringFields() +
                ",femalesAged16to74InEmployment" +
                ",femalesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials" +
                ",femalesAged16to74InEmploymentWorkingAsProfessionalOccupations" +
                ",femalesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations" +
                ",femalesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations" +
                ",femalesAged16to74InEmploymentWorkingAsSkilledTradesOccupations" +
                ",femalesAged16to74InEmploymentWorkingAsPersonalServiceOccupations" +
                ",femalesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations" +
                ",femalesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives" +
                ",femalesAged16to74InEmploymentWorkingAsElementaryOccupations";
    }

    /**
     * Returns a copy of this.femalesAged16to74InEmployment
     * @return 
     */
    public int getFemalesAged16to74InEmployment() {
        return this.femalesAged16to74InEmployment;
    }

    /**
     * Returns a copy of
     * this.femalesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials
     * @return 
     */
    public int getFemalesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials() {
        return this.femalesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials;
    }

    /**
     * Returns a copy of
     * this.femalesAged16to74InEmploymentWorkingAsProfessionalOccupations
     * @return 
     */
    public int getFemalesAged16to74InEmploymentWorkingAsProfessionalOccupations() {
        return this.femalesAged16to74InEmploymentWorkingAsProfessionalOccupations;
    }

    /**
     * Returns a copy of this.femalesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations
     * @return 
     */
    public int getFemalesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations() {
        return this.femalesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations;
    }

    /**
     * Returns a copy of this.
     * femalesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations
     * @return 
     */
    public int getFemalesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations() {
        return this.femalesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations;
    }

    /**
     * Returns a copy of
     * this.femalesAged16to74InEmploymentWorkingAsSkilledTradesOccupations
     * @return 
     */
    public int getFemalesAged16to74InEmploymentWorkingAsSkilledTradesOccupations() {
        return this.femalesAged16to74InEmploymentWorkingAsSkilledTradesOccupations;
    }

    /**
     * Returns a copy of
     * this.femalesAged16to74InEmploymentWorkingAsPersonalServiceOccupations
     * @return 
     */
    public int getFemalesAged16to74InEmploymentWorkingAsPersonalServiceOccupations() {
        return this.femalesAged16to74InEmploymentWorkingAsPersonalServiceOccupations;
    }

    /**
     * Returns a copy of this.
     * femalesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations
     * @return 
     */
    public int getFemalesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations() {
        return this.femalesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations;
    }

    /**
     * Returns a copy of this.
     * femalesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives
     * @return 
     */
    public int getFemalesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives() {
        return this.femalesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives;
    }

    /**
     * Returns a copy of
     * this.femalesAged16to74InEmploymentWorkingAsElementaryOccupations
     * @return 
     */
    public int getFemalesAged16to74InEmploymentWorkingAsElementaryOccupations() {
        return this.femalesAged16to74InEmploymentWorkingAsElementaryOccupations;
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
    public void write(RandomAccessFile aRandomAccessFile,
            boolean avoidCallToSuper) {
        if (avoidCallToSuper) {
            try {
                aRandomAccessFile.writeInt(femalesAged16to74InEmployment);
                aRandomAccessFile.writeInt(femalesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials);
                aRandomAccessFile.writeInt(femalesAged16to74InEmploymentWorkingAsProfessionalOccupations);
                aRandomAccessFile.writeInt(femalesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations);
                aRandomAccessFile.writeInt(femalesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations);
                aRandomAccessFile.writeInt(femalesAged16to74InEmploymentWorkingAsSkilledTradesOccupations);
                aRandomAccessFile.writeInt(femalesAged16to74InEmploymentWorkingAsPersonalServiceOccupations);
                aRandomAccessFile.writeInt(femalesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations);
                aRandomAccessFile.writeInt(femalesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives);
                aRandomAccessFile.writeInt(femalesAged16to74InEmploymentWorkingAsElementaryOccupations);
            } catch (IOException aIOException) {
                System.err.println(aIOException.getLocalizedMessage());
                System.exit(Generic_ErrorAndExceptionHandler.IOException);
            }
        } else {
            write(aRandomAccessFile);
        }
    }

    /**
     * @return An aggregated <code>Census_CASKS12cDataRecord</code> where:
     *         <code>RecordID = this.RecordID</code>
     *         <code>Zone_Code = this.Zone_Code</code> For aggregating
     *         <code>CASKS12cDataRecords</code>. User needs to take care in
     *         aggregating to ensure aggregation does not compromise (introduce
     *         error) based on the numbers used (i.e. numbers may not be precise
     *         or have sufficient magnitude).
     * @param aCASKS12cDataRecord
     *            The <code>Census_CASKS12cDataRecord</code> to be aggregated with
     *            <code>this</code>.
     */
    public Census_CASKS12cDataRecord aggregate(Census_CASKS12cDataRecord aCASKS12cDataRecord) {
        Census_CASKS12cDataRecord newCASKS12cDataRecord = new Census_CASKS12cDataRecord(
                aCASKS12cDataRecord);
        newCASKS12cDataRecord.femalesAged16to74InEmployment += getFemalesAged16to74InEmployment();
        newCASKS12cDataRecord.femalesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials += getFemalesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials();
        newCASKS12cDataRecord.femalesAged16to74InEmploymentWorkingAsProfessionalOccupations += getFemalesAged16to74InEmploymentWorkingAsProfessionalOccupations();
        newCASKS12cDataRecord.femalesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations += getFemalesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations();
        newCASKS12cDataRecord.femalesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations += getFemalesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations();
        newCASKS12cDataRecord.femalesAged16to74InEmploymentWorkingAsSkilledTradesOccupations += getFemalesAged16to74InEmploymentWorkingAsSkilledTradesOccupations();
        newCASKS12cDataRecord.femalesAged16to74InEmploymentWorkingAsPersonalServiceOccupations = getFemalesAged16to74InEmploymentWorkingAsPersonalServiceOccupations();
        newCASKS12cDataRecord.femalesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations = getFemalesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations();
        newCASKS12cDataRecord.femalesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives += getFemalesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives();
        newCASKS12cDataRecord.femalesAged16to74InEmploymentWorkingAsElementaryOccupations += getFemalesAged16to74InEmploymentWorkingAsElementaryOccupations();
        return newCASKS12cDataRecord;
    }

    /**
     * @return An aggregated <code>Census_CASKS12cDataRecord</code> where:
     *         <code>RecordID = newRecordID</code>
     *         <code>Zone_Code = newZone_Code</code> For aggregating
     *         <code>CASKS12cDataRecords</code>. User needs to take care in
     *         aggregating to ensure aggregation does not compromise (introduce
     *         error) based on the numbers used (i.e. numbers may not be precise
     *         or have sufficient magnitude).
     * @param aCASKS12cDataRecord
     *            The <code>Census_CASKS12cDataRecord</code> to be aggregated with
     *            <code>this</code>.
     * @param newRecordID
     *            The <code>RecordID</code> assigned to result.
     * @param newZone_Code
     *            The <code>Zone_Code</code> assigned to result.
     */
    public Census_CASKS12cDataRecord aggregate(
            Census_CASKS12cDataRecord aCASKS12cDataRecord,
            long newRecordID,
            char[] newZone_Code) {
        Census_CASKS12cDataRecord newCASKS12cDataRecord = new Census_CASKS12cDataRecord(this);
        newCASKS12cDataRecord.RecordID = newRecordID;
        // newCASKS12cDataRecord.Zone_Code = aCASKS12cDataRecord.Zone_Code;
        int aZone_CodeID = 0;
        for (int Zone_CodeID = 0; Zone_CodeID < newZone_Code.length; Zone_CodeID++) {
            newCASKS12cDataRecord.Zone_Code[Zone_CodeID] = newZone_Code[Zone_CodeID];
            aZone_CodeID = Zone_CodeID;
        }
        for (int Zone_CodeID = aZone_CodeID; Zone_CodeID < Zone_Code.length; Zone_CodeID++) {
            newCASKS12cDataRecord.Zone_Code[Zone_CodeID] = ' ';
        }
        newCASKS12cDataRecord.femalesAged16to74InEmployment += getFemalesAged16to74InEmployment();
        newCASKS12cDataRecord.femalesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials += getFemalesAged16to74InEmploymentWorkingAsManagersAndSeniorOfficials();
        newCASKS12cDataRecord.femalesAged16to74InEmploymentWorkingAsProfessionalOccupations += getFemalesAged16to74InEmploymentWorkingAsProfessionalOccupations();
        newCASKS12cDataRecord.femalesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations += getFemalesAged16to74InEmploymentWorkingAsAssociateProfessionalAndTechnicalOccupations();
        newCASKS12cDataRecord.femalesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations += getFemalesAged16to74InEmploymentWorkingAsAdministrativeAndSecretarialOccupations();
        newCASKS12cDataRecord.femalesAged16to74InEmploymentWorkingAsSkilledTradesOccupations += getFemalesAged16to74InEmploymentWorkingAsSkilledTradesOccupations();
        newCASKS12cDataRecord.femalesAged16to74InEmploymentWorkingAsPersonalServiceOccupations = getFemalesAged16to74InEmploymentWorkingAsPersonalServiceOccupations();
        newCASKS12cDataRecord.femalesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations = getFemalesAged16to74InEmploymentWorkingAsSalesAndCustomerServiceOccupations();
        newCASKS12cDataRecord.femalesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives += getFemalesAged16to74InEmploymentWorkingAsProcessPlantAndMachineOperatives();
        newCASKS12cDataRecord.femalesAged16to74InEmploymentWorkingAsElementaryOccupations += getFemalesAged16to74InEmploymentWorkingAsElementaryOccupations();
        return newCASKS12cDataRecord;
    }

    /**
     * Returns the size of this CASKS12cRecord in bytes as a long. This does not
     * account for serialVersionUID. A boolean is assumed to be the same size as
     * an int in bytes.
     * @return 
     */
    @Override
    public long getSizeInBytes() {
        long result = super.getSizeInBytes();
        result += (10L * (long) Integer.SIZE) / getNumberOfBitsInByte();
        return result;
    }
}
