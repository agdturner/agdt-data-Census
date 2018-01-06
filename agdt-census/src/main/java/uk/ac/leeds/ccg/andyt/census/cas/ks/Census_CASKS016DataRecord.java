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
 * For representing CAS KS016 Records and providing safe access to the data.
 */
public class Census_CASKS016DataRecord extends Census_AbstractDataRecord {

    /*
     * Table KS016 Household spaces and accommodation type: All household spaces
     * NB: This table contains counts of Household spaces Footnotes and Comments
     * for Table KS016 1. 'In commercial building' includes in an office
     * building; or hotel; or over a shop.
     */
    /**
     * KS0160001 = allHouseholdSpacesWithResidents
     */
    protected int allHouseholdSpacesWithResidents;
    /**
     * KS0160002 = allHouseholdSpacesWithNoResidentsVacant
     */
    protected int allHouseholdSpacesWithNoResidentsVacant;
    /**
     * KS0160003 =
     * allHouseholdSpacesWithNoResidentsSecondResidenceHolidayAccommodation
     */
    protected int allHouseholdSpacesWithNoResidentsSecondResidenceHolidayAccommodation;
    /**
     * KS0160004 =
     * allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowDetached
     */
    protected int allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowDetached;
    /**
     * KS0160005 =
     * allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowSemiDetached
     */
    protected int allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowSemiDetached;
    /**
     * KS0160006 =allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowTerracedIncludingEndTerrace
     */
    protected int allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowTerracedIncludingEndTerrace;
    /**
     * KS0160007 =allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPurposeBuiltBlockOfFlatsOrTenement
     */
    protected int allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPurposeBuiltBlockOfFlatsOrTenement;
    /**
     * KS0160008 =allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPartOfAConvertedOrSharedHouseIncludingBedSits
     */
    protected int allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPartOfAConvertedOrSharedHouseIncludingBedSits;
    /**
     * KS0160009 =allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentInACommercialBuilding
     */
    protected int allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentInACommercialBuilding;
    /**
     * KS0160010 =allHouseholdSpacesWhichAreOfAccommodationTypeCaravanOrOtherMobileOrTemporaryStructure
     */
    protected int allHouseholdSpacesWhichAreOfAccommodationTypeCaravanOrOtherMobileOrTemporaryStructure;

    /** Creates a new CASKS12bRecord */
    public Census_CASKS016DataRecord() {
        init();
    }

    /**
     * Creates a new CASKS016Record cloned from aCASKS016Record
     *
     * @param aCASKS016Record
     *            The CASKS016Record from which this is cloned.
     */
    public Census_CASKS016DataRecord(Census_CASKS016DataRecord aCASKS016Record) {
        init(aCASKS016Record);
    }

    /**
     * Creates a new CASKS016DataRecord
     *
     * @param initZero
     *            To ensure initZero() is used instead of init()
     */
    public Census_CASKS016DataRecord(boolean initZero) {
        initZero();
    }

    /**
     * Creates a new CASKS016Record
     *
     * @param aRandomAccessFile
     */
    public Census_CASKS016DataRecord(RandomAccessFile aRandomAccessFile) {
        try {
            this.RecordID = aRandomAccessFile.readLong();
            this.Zone_Code = new char[10];
            for (int i = 0; i < this.Zone_Code.length; i++) {
                Zone_Code[i] = aRandomAccessFile.readChar();
            }
            this.allHouseholdSpacesWithResidents = aRandomAccessFile.readInt();
            this.allHouseholdSpacesWithNoResidentsVacant = aRandomAccessFile.readInt();
            this.allHouseholdSpacesWithNoResidentsSecondResidenceHolidayAccommodation = aRandomAccessFile.readInt();
            this.allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowDetached = aRandomAccessFile.readInt();
            this.allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowSemiDetached = aRandomAccessFile.readInt();
            this.allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowTerracedIncludingEndTerrace = aRandomAccessFile.readInt();
            this.allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPurposeBuiltBlockOfFlatsOrTenement = aRandomAccessFile.readInt();
            this.allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPartOfAConvertedOrSharedHouseIncludingBedSits = aRandomAccessFile.readInt();
            this.allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentInACommercialBuilding = aRandomAccessFile.readInt();
            this.allHouseholdSpacesWhichAreOfAccommodationTypeCaravanOrOtherMobileOrTemporaryStructure = aRandomAccessFile.readInt();
        } catch (IOException ioe0) {
            ioe0.printStackTrace();
        }
    }

    /**
     * Initialises.
     */
    protected void init() {
        super.init();
        this.allHouseholdSpacesWithResidents = Integer.MIN_VALUE;
        this.allHouseholdSpacesWithNoResidentsVacant = Integer.MIN_VALUE;
        this.allHouseholdSpacesWithNoResidentsSecondResidenceHolidayAccommodation = Integer.MIN_VALUE;
        this.allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowDetached = Integer.MIN_VALUE;
        this.allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowSemiDetached = Integer.MIN_VALUE;
        this.allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowTerracedIncludingEndTerrace = Integer.MIN_VALUE;
        this.allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPurposeBuiltBlockOfFlatsOrTenement = Integer.MIN_VALUE;
        this.allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPartOfAConvertedOrSharedHouseIncludingBedSits = Integer.MIN_VALUE;
        this.allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentInACommercialBuilding = Integer.MIN_VALUE;
        this.allHouseholdSpacesWhichAreOfAccommodationTypeCaravanOrOtherMobileOrTemporaryStructure = Integer.MIN_VALUE;
    }

    /**
     * Initialises to zero.
     */
    protected void initZero() {
        super.init();
        this.allHouseholdSpacesWithResidents = 0;
        this.allHouseholdSpacesWithNoResidentsVacant = 0;
        this.allHouseholdSpacesWithNoResidentsSecondResidenceHolidayAccommodation = 0;
        this.allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowDetached = 0;
        this.allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowSemiDetached = 0;
        this.allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowTerracedIncludingEndTerrace = 0;
        this.allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPurposeBuiltBlockOfFlatsOrTenement = 0;
        this.allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPartOfAConvertedOrSharedHouseIncludingBedSits = 0;
        this.allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentInACommercialBuilding = 0;
        this.allHouseholdSpacesWhichAreOfAccommodationTypeCaravanOrOtherMobileOrTemporaryStructure = 0;
    }

    /**
     * Returns a string description of this;
     * @return 
     */
    public String toString() {
        return super.toString() + ", allHouseholdSpacesWithResidents " + allHouseholdSpacesWithResidents + ", allHouseholdSpacesWithNoResidentsVacant " + allHouseholdSpacesWithNoResidentsVacant + ", allHouseholdSpacesWithNoResidentsSecondResidenceHolidayAccommodation " + allHouseholdSpacesWithNoResidentsSecondResidenceHolidayAccommodation + ", allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowDetached " + allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowDetached + ", allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowSemiDetached " + allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowSemiDetached + ", allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowTerracedIncludingEndTerrace " + allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowTerracedIncludingEndTerrace + ", allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPurposeBuiltBlockOfFlatsOrTenement " + allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPurposeBuiltBlockOfFlatsOrTenement + ", allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPartOfAConvertedOrSharedHouseIncludingBedSits " + allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPartOfAConvertedOrSharedHouseIncludingBedSits + ", allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentInACommercialBuilding " + allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentInACommercialBuilding + ", allHouseholdSpacesWhichAreOfAccommodationTypeCaravanOrOtherMobileOrTemporaryStructure " + allHouseholdSpacesWhichAreOfAccommodationTypeCaravanOrOtherMobileOrTemporaryStructure;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the values
     *         of the <code>Fields</code> of <code>this</code>.
     */
    @Override
    public String toCSVString() {
        return super.toCSVString() + "," + allHouseholdSpacesWithResidents + "," + allHouseholdSpacesWithNoResidentsVacant + "," + allHouseholdSpacesWithNoResidentsSecondResidenceHolidayAccommodation + "," + allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowDetached + "," + allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowSemiDetached + "," + allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowTerracedIncludingEndTerrace + "," + allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPurposeBuiltBlockOfFlatsOrTenement + "," + allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPartOfAConvertedOrSharedHouseIncludingBedSits + "," + allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentInACommercialBuilding + "," + allHouseholdSpacesWhichAreOfAccommodationTypeCaravanOrOtherMobileOrTemporaryStructure;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the names
     *         of the <code>Fields</code> of <code>this</code>
     */
    @Override
    public String toCSVStringFields() {
        return super.toCSVStringFields() + ",allHouseholdSpacesWithResidents" + ",allHouseholdSpacesWithNoResidentsVacant" + ",allHouseholdSpacesWithNoResidentsSecondResidenceHolidayAccommodation" + ",allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowDetached" + ",allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowSemiDetached" + ",allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowTerracedIncludingEndTerrace" + ",allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPurposeBuiltBlockOfFlatsOrTenement" + ",allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPartOfAConvertedOrSharedHouseIncludingBedSits" + ",allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentInACommercialBuilding" + ",allHouseholdSpacesWhichAreOfAccommodationTypeCaravanOrOtherMobileOrTemporaryStructure";
    }

    /**
     * Returns a copy of this.allHouseholdSpacesWithResidents
     * @return 
     */
    public int getAllHouseholdSpacesWithResidents() {
        return this.allHouseholdSpacesWithResidents;
    }

    /**
     * Returns a copy of this.allHouseholdSpacesWithNoResidentsVacant
     * @return 
     */
    public int getAllHouseholdSpacesWithNoResidentsVacant() {
        return this.allHouseholdSpacesWithNoResidentsVacant;
    }

    /**
     * Returns a copy of this.
     * allHouseholdSpacesWithNoResidentsSecondResidenceHolidayAccommodation
     * @return 
     */
    public int getAllHouseholdSpacesWithNoResidentsSecondResidenceHolidayAccommodation() {
        return this.allHouseholdSpacesWithNoResidentsSecondResidenceHolidayAccommodation;
    }

    /**
     * Returns a copy of this.
     * allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowDetached
     * @return 
     */
    public int getAllHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowDetached() {
        return this.allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowDetached;
    }

    /**
     * Returns a copy of this.
     * allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowSemiDetached
     * @return 
     */
    public int getAllHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowSemiDetached() {
        return this.allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowSemiDetached;
    }

    /**
     * Returns a copy of this.allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowTerracedIncludingEndTerrace
     * @return 
     */
    public int getAllHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowTerracedIncludingEndTerrace() {
        return this.allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowTerracedIncludingEndTerrace;
    }

    /**
     * Returns a copy of this.allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPurposeBuiltBlockOfFlatsOrTenement
     * @return 
     */
    public int getAllHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPurposeBuiltBlockOfFlatsOrTenement() {
        return this.allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPurposeBuiltBlockOfFlatsOrTenement;
    }

    /**
     * Returns a copy of this.allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPartOfAConvertedOrSharedHouseIncludingBedSits
     * @return 
     */
    public int getAllHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPartOfAConvertedOrSharedHouseIncludingBedSits() {
        return this.allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPartOfAConvertedOrSharedHouseIncludingBedSits;
    }

    /**
     * Returns a copy of this.allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentInACommercialBuilding
     * @return 
     */
    public int getAllHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentInACommercialBuilding() {
        return this.allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentInACommercialBuilding;
    }

    /**
     * Returns a copy of this.allHouseholdSpacesWhichAreOfAccommodationTypeCaravanOrOtherMobileOrTemporaryStructure
     * @return 
     */
    public int getAllHouseholdSpacesWhichAreOfAccommodationTypeCaravanOrOtherMobileOrTemporaryStructure() {
        return this.allHouseholdSpacesWhichAreOfAccommodationTypeCaravanOrOtherMobileOrTemporaryStructure;
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
                aRandomAccessFile.writeInt(allHouseholdSpacesWithResidents);
                aRandomAccessFile.writeInt(allHouseholdSpacesWithNoResidentsVacant);
                aRandomAccessFile.writeInt(allHouseholdSpacesWithNoResidentsSecondResidenceHolidayAccommodation);
                aRandomAccessFile.writeInt(allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowDetached);
                aRandomAccessFile.writeInt(allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowSemiDetached);
                aRandomAccessFile.writeInt(allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowTerracedIncludingEndTerrace);
                aRandomAccessFile.writeInt(allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPurposeBuiltBlockOfFlatsOrTenement);
                aRandomAccessFile.writeInt(allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPartOfAConvertedOrSharedHouseIncludingBedSits);
                aRandomAccessFile.writeInt(allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentInACommercialBuilding);
                aRandomAccessFile.writeInt(allHouseholdSpacesWhichAreOfAccommodationTypeCaravanOrOtherMobileOrTemporaryStructure);
            } catch (IOException aIOException) {
                System.err.println(aIOException.getLocalizedMessage());
                System.exit(Generic_ErrorAndExceptionHandler.IOException);
            }
        } else {
            write(aRandomAccessFile);
        }
    }

    /**
     * @return An aggregated <code>Census_CASKS016DataRecord</code> where:
     *         <code>RecordID = this.RecordID</code>
     *         <code>Zone_Code = this.Zone_Code</code> For aggregating
     *         <code>CASKS016DataRecords</code>. User needs to take care in
     *         aggregating to ensure aggregation does not compromise (introduce
     *         error) based on the numbers used (i.e. numbers may not be precise
     *         or have sufficient magnitude).
     * @param aCASKS016DataRecord
     *            The <code>Census_CASKS016DataRecord</code> to be aggregated with
     *            <code>this</code>.
     */
    public Census_CASKS016DataRecord aggregate(Census_CASKS016DataRecord aCASKS016DataRecord) {
        Census_CASKS016DataRecord newCASKS016DataRecord = new Census_CASKS016DataRecord(
                aCASKS016DataRecord);
        newCASKS016DataRecord.allHouseholdSpacesWithResidents = getAllHouseholdSpacesWithResidents();
        newCASKS016DataRecord.allHouseholdSpacesWithNoResidentsVacant = getAllHouseholdSpacesWithNoResidentsVacant();
        newCASKS016DataRecord.allHouseholdSpacesWithNoResidentsSecondResidenceHolidayAccommodation = getAllHouseholdSpacesWithNoResidentsSecondResidenceHolidayAccommodation();
        newCASKS016DataRecord.allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowDetached = getAllHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowDetached();
        newCASKS016DataRecord.allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowSemiDetached = getAllHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowSemiDetached();
        newCASKS016DataRecord.allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowTerracedIncludingEndTerrace = getAllHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowTerracedIncludingEndTerrace();
        newCASKS016DataRecord.allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPurposeBuiltBlockOfFlatsOrTenement = getAllHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPurposeBuiltBlockOfFlatsOrTenement();
        newCASKS016DataRecord.allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPartOfAConvertedOrSharedHouseIncludingBedSits = getAllHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPartOfAConvertedOrSharedHouseIncludingBedSits();
        newCASKS016DataRecord.allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentInACommercialBuilding = getAllHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentInACommercialBuilding();
        newCASKS016DataRecord.allHouseholdSpacesWhichAreOfAccommodationTypeCaravanOrOtherMobileOrTemporaryStructure = getAllHouseholdSpacesWhichAreOfAccommodationTypeCaravanOrOtherMobileOrTemporaryStructure();
        return newCASKS016DataRecord;
    }

    /**
     * @return An aggregated <code>Census_CASKS016DataRecord</code> where:
     *         <code>RecordID = newRecordID</code>
     *         <code>Zone_Code = newZone_Code</code> For aggregating
     *         <code>CASKS016DataRecords</code>. User needs to take care in
     *         aggregating to ensure aggregation does not compromise (introduce
     *         error) based on the numbers used (i.e. numbers may not be precise
     *         or have sufficient magnitude).
     * @param aCASKS016DataRecord
     *            The <code>Census_CASKS016DataRecord</code> to be aggregated with
     *            <code>this</code>.
     * @param newRecordID
     *            The <code>RecordID</code> assigned to result.
     * @param newZone_Code
     *            The <code>Zone_Code</code> assigned to result.
     */
    public Census_CASKS016DataRecord aggregate(
            Census_CASKS016DataRecord aCASKS016DataRecord,
            long newRecordID,
            char[] newZone_Code) {
        Census_CASKS016DataRecord newCASKS016DataRecord = new Census_CASKS016DataRecord(this);
        newCASKS016DataRecord.RecordID = newRecordID;
        // newCASKS016DataRecord.Zone_Code = aCASKS016DataRecord.Zone_Code;
        int aZone_CodeID = 0;
        for (int Zone_CodeID = 0; Zone_CodeID < newZone_Code.length; Zone_CodeID++) {
            newCASKS016DataRecord.Zone_Code[Zone_CodeID] = newZone_Code[Zone_CodeID];
            aZone_CodeID = Zone_CodeID;
        }
        for (int Zone_CodeID = aZone_CodeID; Zone_CodeID < Zone_Code.length; Zone_CodeID++) {
            newCASKS016DataRecord.Zone_Code[Zone_CodeID] = ' ';
        }
        newCASKS016DataRecord.allHouseholdSpacesWithResidents = getAllHouseholdSpacesWithResidents();
        newCASKS016DataRecord.allHouseholdSpacesWithNoResidentsVacant = getAllHouseholdSpacesWithNoResidentsVacant();
        newCASKS016DataRecord.allHouseholdSpacesWithNoResidentsSecondResidenceHolidayAccommodation = getAllHouseholdSpacesWithNoResidentsSecondResidenceHolidayAccommodation();
        newCASKS016DataRecord.allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowDetached = getAllHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowDetached();
        newCASKS016DataRecord.allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowSemiDetached = getAllHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowSemiDetached();
        newCASKS016DataRecord.allHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowTerracedIncludingEndTerrace = getAllHouseholdSpacesWhichAreOfAccommodationTypeWholeHouseOrbungalowTerracedIncludingEndTerrace();
        newCASKS016DataRecord.allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPurposeBuiltBlockOfFlatsOrTenement = getAllHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPurposeBuiltBlockOfFlatsOrTenement();
        newCASKS016DataRecord.allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPartOfAConvertedOrSharedHouseIncludingBedSits = getAllHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentPartOfAConvertedOrSharedHouseIncludingBedSits();
        newCASKS016DataRecord.allHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentInACommercialBuilding = getAllHouseholdSpacesWhichAreOfAccommodationTypeFlatMaisonetteOrApartmentInACommercialBuilding();
        newCASKS016DataRecord.allHouseholdSpacesWhichAreOfAccommodationTypeCaravanOrOtherMobileOrTemporaryStructure = getAllHouseholdSpacesWhichAreOfAccommodationTypeCaravanOrOtherMobileOrTemporaryStructure();
        return newCASKS016DataRecord;
    }

    /**
     * Returns the size of this Record in bytes as a long. This does not account
     * for serialVersionUID. A boolean is assumed to be the same size as an int
     * in bytes.
     * @return 
     */
    @Override
    public long getSizeInBytes() {
        long result = super.getSizeInBytes();
        result += (10L * (long) Integer.SIZE) / getNumberOfBitsInByte();
        return result;
    }
}
