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
import uk.ac.leeds.ccg.andyt.generic.math.StaticConverter;

/**
 * For representing CAS KS015 Records and providing safe access to the data. NB.
 * In aggregating it has been noticed that
 * averageDistanceInKMTravelledToFixedPlaceOfWork is perculiar.
 */
public class Census_CASKS015DataRecord extends Census_AbstractDataRecord {

    /*
     * This table is different for Scotland and Northern and Ireland. The cell
     * numbers shown are for England and Wales Table KS015 Travel to Work: All
     * people aged 16-74 in employment Footnotes and Comments for Table KS015 1.
     * The distance travelled is a calculation of the straight line between the
     * postcode of place of residence and postcode of workplace. 2. Excludes
     * working at home, no fixed place of work, working at offshore
     * installation, working outside UK. 3. For the purposes of this table,
     * public transport is defined as Underground, metro, light rail or tram;
     * train; bus, minibus or coach. 4. The number of people who travel to work
     * by public transport who live in a household with/without a car or van is
     * expressed as a percentage of the number of people who travel to work by
     * public transport. These figures may not sum to 100% as residents of
     * communal establishments who travel to work by public transport are not
     * included in these counts.
     */
    /**
     * KS0150001 = peopleAged16to74InEmployment
     */
    protected int peopleAged16to74InEmployment;
    /**
     * KS0150002 = peopleAged16to74InEmploymentWhoWorkMainlyAtOrFromHome
     */
    protected int peopleAged16to74InEmploymentWhoWorkMainlyAtOrFromHome;
    /**
     * KS0150003 =peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByUndergroundMetroLightRailTram
     */
    protected int peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByUndergroundMetroLightRailTram;
    /**
     * KS0150004 = peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTrain
     */
    protected int peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTrain;
    /**
     * KS0150005 =
     * peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBusMinibusOrCoach
     */
    protected int peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBusMinibusOrCoach;
    /**
     * KS0150006 =
     * peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByMotorcycleScooterOrMoped
     */
    protected int peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByMotorcycleScooterOrMoped;
    /**
     * KS0150007 =
     * peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByDrivingACarOrVan
     */
    protected int peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByDrivingACarOrVan;
    /**
     * KS0150008 =
     * peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByPassengerInACarOrVan
     */
    protected int peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByPassengerInACarOrVan;
    /**
     * KS0150009 =
     * peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTaxiOrMinicab
     */
    protected int peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTaxiOrMinicab;
    /**
     * KS0150010 = peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBicycle
     */
    protected int peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBicycle;
    /**
     * KS0150011 = peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOnFoot
     */
    protected int peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOnFoot;
    /**
     * KS0150012 = peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOther
     */
    protected int peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOther;
    /**
     * KS0150013 = averageDistanceInKMTravelledToFixedPlaceOfWork
     */
    protected int averageDistanceInKMTravelledToFixedPlaceOfWork;
    /**
     * KS0150014 = publicTransportUsersInHouseholdsWithACarOrVan
     */
    protected int publicTransportUsersInHouseholdsWithACarOrVan;
    /**
     * KS0150015 = publicTransportUsersInHouseholdsWithoutACarOrVan
     */
    protected int publicTransportUsersInHouseholdsWithoutACarOrVan;

    /** Creates a new CASKS015Record */
    public Census_CASKS015DataRecord() {
        _Init();
    }

    /**
     * Creates a new CASKS015Record cloned from aCASKS015Record
     *
     * @param aCASKS015Record
     *            The CASKS015Record from which this is cloned.
     */
    public Census_CASKS015DataRecord(Census_CASKS015DataRecord aCASKS015Record) {
        init(aCASKS015Record);
    }

    /**
     * Creates a new CASKS015DataRecord
     *
     * @param initZero
     *            To ensure initZero() is used instead of _Init()
     */
    public Census_CASKS015DataRecord(boolean initZero) {
        initZero();
    }

    /**
     * Creates a new CASKS015DataRecord
     *
     * @param RecordID
     *            The RecordID to be assigned to this
     * @param line
     *            The Comma Seperated Value <code>String</code>
     * @param country
     *            Identifies type of table
     *            <ul>
     *            <li>country.equalsIgnoreCase("Northern Ireland") treated as
     *            Northern Ireland CASKS015DataRecord</li>
     *            <li>country.equalsIgnoreCase("Scotland") treated as Scotland
     *            CASKS015DataRecord</li>
     *            <li>country.equalsIgnoreCase("England") treated as England
     *            CASKS015DataRecord</li>
     *            <li>country.equalsIgnoreCase("Wales") treated as Wales
     *            CASKS015DataRecord</li>
     *            </ul>
     * @throws java.io.IOException
     */
    public Census_CASKS015DataRecord(long RecordID, String line, String country)
            throws IOException {
        String[] fieldsDummy = line.split(",");
        String[] fields = new String[16];
        for (int i = 0; i < fields.length; i++) {
            fields[i] = "";
        }
        if (country.equalsIgnoreCase("Scotland")) {
            System.arraycopy(fieldsDummy, 0, fields, 0, 13);
            System.arraycopy(fieldsDummy, 16, fields, 14, 2);
            this._RecordID = RecordID;
            this.Zone_Code = fields[0].substring(1, 11).toCharArray();
            // From Table KS015
            this.peopleAged16to74InEmployment = StaticConverter.to_int(fields[1]);
            this.peopleAged16to74InEmploymentWhoWorkMainlyAtOrFromHome = StaticConverter.to_int(fields[2]);
            this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByUndergroundMetroLightRailTram = StaticConverter.to_int(fields[3]);
            this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTrain = StaticConverter.to_int(fields[4]);
            this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBusMinibusOrCoach = StaticConverter.to_int(fields[5]);
            this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByMotorcycleScooterOrMoped = StaticConverter.to_int(fields[6]);
            this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByDrivingACarOrVan = StaticConverter.to_int(fields[7]);
            this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByPassengerInACarOrVan = StaticConverter.to_int(fields[8]);
            this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTaxiOrMinicab = StaticConverter.to_int(fields[9]);
            this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBicycle = StaticConverter.to_int(fields[10]);
            this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOnFoot = StaticConverter.to_int(fields[11]);
            this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOther = StaticConverter.to_int(fields[12]);
            this.averageDistanceInKMTravelledToFixedPlaceOfWork = StaticConverter.to_int(fields[13]);
            this.publicTransportUsersInHouseholdsWithACarOrVan = StaticConverter.to_int(fields[14]);
            this.publicTransportUsersInHouseholdsWithoutACarOrVan = StaticConverter.to_int(fields[15]);
        } else {
            if (country.equalsIgnoreCase("Northern Ireland")) {
                _Init();
                fields = new String[15];
                System.arraycopy(fieldsDummy, 0, fields, 0, fields.length);
                this._RecordID = RecordID;
                this.Zone_Code = fields[0].substring(1, 11).toCharArray();
                // From Table KS015
                this.peopleAged16to74InEmployment = StaticConverter.to_int(fields[1]);
                this.peopleAged16to74InEmploymentWhoWorkMainlyAtOrFromHome = StaticConverter.to_int(fields[2]);
                this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTrain = StaticConverter.to_int(fields[3]);
                this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBusMinibusOrCoach = StaticConverter.to_int(fields[4]);
                this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByMotorcycleScooterOrMoped = StaticConverter.to_int(fields[5]);
                this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByDrivingACarOrVan = StaticConverter.to_int(fields[6]);
                this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByPassengerInACarOrVan = StaticConverter.to_int(fields[7]);
                // this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByCarOrVanPool
                // = StaticConverter.to_int( fields[ 8 ] );
                // this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTaxi
                // = StaticConverter.to_int( fields[ 9 ] );
                this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTaxiOrMinicab = StaticConverter.to_int(fields[9]);
                this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBicycle = StaticConverter.to_int(fields[10]);
                this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOnFoot = StaticConverter.to_int(fields[11]);
                this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOther = StaticConverter.to_int(fields[12]) + StaticConverter.to_int(fields[8]);
                this.publicTransportUsersInHouseholdsWithACarOrVan = StaticConverter.to_int(fields[13]);
                this.publicTransportUsersInHouseholdsWithoutACarOrVan = StaticConverter.to_int(fields[14]);
            } else {
                // if ( country.equalsIgnoreCase( "England" ) ||
                // country.equalsIgnoreCase( "Wales" ) ) {
                System.arraycopy(fieldsDummy, 0, fields, 0, fields.length);
                this._RecordID = RecordID;
                this.Zone_Code = fields[0].substring(1, 11).toCharArray();
                // From Table KS015
                this.peopleAged16to74InEmployment = StaticConverter.to_int(fields[1]);
                this.peopleAged16to74InEmploymentWhoWorkMainlyAtOrFromHome = StaticConverter.to_int(fields[2]);
                this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByUndergroundMetroLightRailTram = StaticConverter.to_int(fields[3]);
                this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTrain = StaticConverter.to_int(fields[4]);
                this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBusMinibusOrCoach = StaticConverter.to_int(fields[5]);
                this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByMotorcycleScooterOrMoped = StaticConverter.to_int(fields[6]);
                this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByDrivingACarOrVan = StaticConverter.to_int(fields[7]);
                this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByPassengerInACarOrVan = StaticConverter.to_int(fields[8]);
                this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTaxiOrMinicab = StaticConverter.to_int(fields[9]);
                this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBicycle = StaticConverter.to_int(fields[10]);
                this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOnFoot = StaticConverter.to_int(fields[11]);
                this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOther = StaticConverter.to_int(fields[12]);
                this.averageDistanceInKMTravelledToFixedPlaceOfWork = StaticConverter.to_int(fields[13]);
                this.publicTransportUsersInHouseholdsWithACarOrVan = StaticConverter.to_int(fields[14]);
                this.publicTransportUsersInHouseholdsWithoutACarOrVan = StaticConverter.to_int(fields[15]);
            }
        }
    }

    /**
     * Creates a new CASKS12bRecord
     *
     * @param tRandomAccessFile
     */
    public Census_CASKS015DataRecord(RandomAccessFile tRandomAccessFile) {
        try {
            this._RecordID = tRandomAccessFile.readLong();
            this.Zone_Code = new char[10];
            for (int i = 0; i < this.Zone_Code.length; i++) {
                Zone_Code[i] = tRandomAccessFile.readChar();
            }
            this.peopleAged16to74InEmployment = tRandomAccessFile.readInt();
            this.peopleAged16to74InEmploymentWhoWorkMainlyAtOrFromHome = tRandomAccessFile.readInt();
            this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByUndergroundMetroLightRailTram = tRandomAccessFile.readInt();
            this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTrain = tRandomAccessFile.readInt();
            this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBusMinibusOrCoach = tRandomAccessFile.readInt();
            this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByMotorcycleScooterOrMoped = tRandomAccessFile.readInt();
            this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByDrivingACarOrVan = tRandomAccessFile.readInt();
            this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByPassengerInACarOrVan = tRandomAccessFile.readInt();
            this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTaxiOrMinicab = tRandomAccessFile.readInt();
            this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBicycle = tRandomAccessFile.readInt();
            this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOnFoot = tRandomAccessFile.readInt();
            this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOther = tRandomAccessFile.readInt();
            this.averageDistanceInKMTravelledToFixedPlaceOfWork = tRandomAccessFile.readInt();
            this.publicTransportUsersInHouseholdsWithACarOrVan = tRandomAccessFile.readInt();
            this.publicTransportUsersInHouseholdsWithoutACarOrVan = tRandomAccessFile.readInt();
        } catch (IOException ioe0) {
            ioe0.printStackTrace();
        }
    }

    /**
     * Initialises.
     */
    protected void _Init() {
        super._Init();
        this.peopleAged16to74InEmployment = Integer.MIN_VALUE;
        this.peopleAged16to74InEmploymentWhoWorkMainlyAtOrFromHome = Integer.MIN_VALUE;
        this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByUndergroundMetroLightRailTram = Integer.MIN_VALUE;
        this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTrain = Integer.MIN_VALUE;
        this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBusMinibusOrCoach = Integer.MIN_VALUE;
        this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByMotorcycleScooterOrMoped = Integer.MIN_VALUE;
        this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByDrivingACarOrVan = Integer.MIN_VALUE;
        this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByPassengerInACarOrVan = Integer.MIN_VALUE;
        this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTaxiOrMinicab = Integer.MIN_VALUE;
        this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBicycle = Integer.MIN_VALUE;
        this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOnFoot = Integer.MIN_VALUE;
        this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOther = Integer.MIN_VALUE;
        this.averageDistanceInKMTravelledToFixedPlaceOfWork = Integer.MIN_VALUE;
        this.publicTransportUsersInHouseholdsWithACarOrVan = Integer.MIN_VALUE;
        this.publicTransportUsersInHouseholdsWithoutACarOrVan = Integer.MIN_VALUE;
    }

    /**
     * Initialises all fields from those in aCASKS015Record.
     *
     * @param aCASKS015Record
     *            The CASKS015Record thats fields are used to initialise this.
     */
    protected void init(Census_CASKS015DataRecord aCASKS015Record) {
        super._Init();
        this.peopleAged16to74InEmployment = aCASKS015Record.peopleAged16to74InEmployment;
        this.peopleAged16to74InEmploymentWhoWorkMainlyAtOrFromHome = aCASKS015Record.peopleAged16to74InEmploymentWhoWorkMainlyAtOrFromHome;
        this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByUndergroundMetroLightRailTram = aCASKS015Record.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByUndergroundMetroLightRailTram;
        this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTrain = aCASKS015Record.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTrain;
        this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBusMinibusOrCoach = aCASKS015Record.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBusMinibusOrCoach;
        this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByMotorcycleScooterOrMoped = aCASKS015Record.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByMotorcycleScooterOrMoped;
        this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByDrivingACarOrVan = aCASKS015Record.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByDrivingACarOrVan;
        this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByPassengerInACarOrVan = aCASKS015Record.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByPassengerInACarOrVan;
        this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTaxiOrMinicab = aCASKS015Record.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTaxiOrMinicab;
        this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBicycle = aCASKS015Record.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBicycle;
        this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOnFoot = aCASKS015Record.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOnFoot;
        this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOther = aCASKS015Record.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOther;
        this.averageDistanceInKMTravelledToFixedPlaceOfWork = aCASKS015Record.averageDistanceInKMTravelledToFixedPlaceOfWork;
        this.publicTransportUsersInHouseholdsWithACarOrVan = aCASKS015Record.publicTransportUsersInHouseholdsWithACarOrVan;
        this.publicTransportUsersInHouseholdsWithoutACarOrVan = aCASKS015Record.publicTransportUsersInHouseholdsWithoutACarOrVan;
    }

    /**
     * Initialises to zero.
     */
    protected void initZero() {
        super._Init();
        this.peopleAged16to74InEmployment = 0;
        this.peopleAged16to74InEmploymentWhoWorkMainlyAtOrFromHome = 0;
        this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByUndergroundMetroLightRailTram = 0;
        this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTrain = 0;
        this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBusMinibusOrCoach = 0;
        this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByMotorcycleScooterOrMoped = 0;
        this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByDrivingACarOrVan = 0;
        this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByPassengerInACarOrVan = 0;
        this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTaxiOrMinicab = 0;
        this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBicycle = 0;
        this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOnFoot = 0;
        this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOther = 0;
        this.averageDistanceInKMTravelledToFixedPlaceOfWork = 0;
        this.publicTransportUsersInHouseholdsWithACarOrVan = 0;
        this.publicTransportUsersInHouseholdsWithoutACarOrVan = 0;
    }

    /**
     * Returns a string description of this;
     * @return 
     */
    public String toString() {
        return super.toString() + ", peopleAged16to74InEmployment " + peopleAged16to74InEmployment + ", peopleAged16to74InEmploymentWhoWorkMainlyAtOrFromHome " + peopleAged16to74InEmploymentWhoWorkMainlyAtOrFromHome + ", peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByUndergroundMetroLightRailTram " + peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByUndergroundMetroLightRailTram + ", peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTrain " + peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTrain + ", peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBusMinibusOrCoach " + peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBusMinibusOrCoach + ", peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByMotorcycleScooterOrMoped " + peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByMotorcycleScooterOrMoped + ", peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByDrivingACarOrVan " + peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByDrivingACarOrVan + ", peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByPassengerInACarOrVan " + peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByPassengerInACarOrVan + ", peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTaxiOrMinicab " + peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTaxiOrMinicab + ", peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBicycle " + peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBicycle + ", peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOnFoot " + peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOnFoot + ", peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOther " + peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOther + ", averageDistanceInKMTravelledToFixedPlaceOfWork " + averageDistanceInKMTravelledToFixedPlaceOfWork + ", publicTransportUsersInHouseholdsWithACarOrVan " + publicTransportUsersInHouseholdsWithACarOrVan + ", publicTransportUsersInHouseholdsWithoutACarOrVan " + publicTransportUsersInHouseholdsWithoutACarOrVan;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the values
     *         of the <code>Fields</code> of <code>this</code>.
     */
    @Override
    public String toCSVString() {
        return super.toCSVString() + "," + peopleAged16to74InEmployment + "," + peopleAged16to74InEmploymentWhoWorkMainlyAtOrFromHome + "," + peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByUndergroundMetroLightRailTram + "," + peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTrain + "," + peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBusMinibusOrCoach + "," + peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByMotorcycleScooterOrMoped + "," + peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByDrivingACarOrVan + "," + peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByPassengerInACarOrVan + "," + peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTaxiOrMinicab + "," + peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBicycle + "," + peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOnFoot + "," + peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOther + "," + averageDistanceInKMTravelledToFixedPlaceOfWork + "," + publicTransportUsersInHouseholdsWithACarOrVan + "," + publicTransportUsersInHouseholdsWithoutACarOrVan;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the names
     *         of the <code>Fields</code> of <code>this</code>
     */
    @Override
    public String toCSVStringFields() {
        return super.toCSVStringFields() + ",peopleAged16to74InEmployment" + ",peopleAged16to74InEmploymentWhoWorkMainlyAtOrFromHome" + ",peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByUndergroundMetroLightRailTram" + ",peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTrain" + ",peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBusMinibusOrCoach" + ",peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByMotorcycleScooterOrMoped" + ",peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByDrivingACarOrVan" + ",peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByPassengerInACarOrVan" + ",peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTaxiOrMinicab" + ",peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBicycle" + ",peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOnFoot" + ",peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOther" + ",averageDistanceInKMTravelledToFixedPlaceOfWork" + ",publicTransportUsersInHouseholdsWithACarOrVan" + ",publicTransportUsersInHouseholdsWithoutACarOrVan";
    }

    /**
     * Returns a copy of this.peopleAged16to74InEmployment
     * @return 
     */
    public int getPeopleAged16to74InEmployment() {
        return this.peopleAged16to74InEmployment;
    }

    /**
     * Returns a copy of
     * this.peopleAged16to74InEmploymentWhoWorkMainlyAtOrFromHome
     * @return 
     */
    public int getPeopleAged16to74InEmploymentWhoWorkMainlyAtOrFromHome() {
        return this.peopleAged16to74InEmploymentWhoWorkMainlyAtOrFromHome;
    }

    /**
     * Returns a copy of this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByUndergroundMetroLightRailTram
     * @return 
     */
    public int getPeopleAged16to74InEmploymentWhoUsuallyTravelToWorkByUndergroundMetroLightRailTram() {
        return this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByUndergroundMetroLightRailTram;
    }

    /**
     * Returns a copy of
     * this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTrain
     * @return 
     */
    public int getPeopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTrain() {
        return this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTrain;
    }

    /**
     * Returns a copy of this.
     * peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBusMinibusOrCoach
     * @return 
     */
    public int getPeopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBusMinibusOrCoach() {
        return this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBusMinibusOrCoach;
    }

    /**
     * Returns a copy of this.
     * peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByMotorcycleScooterOrMoped
     * @return 
     */
    public int getPeopleAged16to74InEmploymentWhoUsuallyTravelToWorkByMotorcycleScooterOrMoped() {
        return this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByMotorcycleScooterOrMoped;
    }

    /**
     * Returns a copy of this.
     * peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByDrivingACarOrVan
     * @return 
     */
    public int getPeopleAged16to74InEmploymentWhoUsuallyTravelToWorkByDrivingACarOrVan() {
        return this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByDrivingACarOrVan;
    }

    /**
     * Returns a copy of this.
     * peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByPassengerInACarOrVan
     * @return 
     */
    public int getPeopleAged16to74InEmploymentWhoUsuallyTravelToWorkByPassengerInACarOrVan() {
        return this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByPassengerInACarOrVan;
    }

    /**
     * Returns a copy of
     * this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTaxiOrMinicab
     * @return 
     */
    public int getPeopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTaxiOrMinicab() {
        return this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTaxiOrMinicab;
    }

    /**
     * Returns a copy of
     * this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBicycle
     * @return 
     */
    public int getPeopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBicycle() {
        return this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBicycle;
    }

    /**
     * Returns a copy of
     * this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOnFoot
     * @return 
     */
    public int getPeopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOnFoot() {
        return this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOnFoot;
    }

    /**
     * Returns a copy of
     * this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOther
     * @return 
     */
    public int getPeopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOther() {
        return this.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOther;
    }

    /**
     * Returns a copy of this.averageDistanceInKMTravelledToFixedPlaceOfWork
     * @return 
     */
    public int getAverageDistanceInKMTravelledToFixedPlaceOfWork() {
        return this.averageDistanceInKMTravelledToFixedPlaceOfWork;
    }

    /**
     * Returns a copy of this.publicTransportUsersInHouseholdsWithACarOrVan
     * @return 
     */
    public int getPublicTransportUsersInHouseholdsWithACarOrVan() {
        return this.publicTransportUsersInHouseholdsWithACarOrVan;
    }

    /**
     * Returns a copy of this.publicTransportUsersInHouseholdsWithoutACarOrVan
     * @return 
     */
    public int getPublicTransportUsersInHouseholdsWithoutACarOrVan() {
        return this.publicTransportUsersInHouseholdsWithoutACarOrVan;
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
                aRandomAccessFile.writeInt(peopleAged16to74InEmployment);
                aRandomAccessFile.writeInt(peopleAged16to74InEmploymentWhoWorkMainlyAtOrFromHome);
                aRandomAccessFile.writeInt(peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByUndergroundMetroLightRailTram);
                aRandomAccessFile.writeInt(peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTrain);
                aRandomAccessFile.writeInt(peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBusMinibusOrCoach);
                aRandomAccessFile.writeInt(peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByMotorcycleScooterOrMoped);
                aRandomAccessFile.writeInt(peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByDrivingACarOrVan);
                aRandomAccessFile.writeInt(peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByPassengerInACarOrVan);
                aRandomAccessFile.writeInt(peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTaxiOrMinicab);
                aRandomAccessFile.writeInt(peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBicycle);
                aRandomAccessFile.writeInt(peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOnFoot);
                aRandomAccessFile.writeInt(peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOther);
                aRandomAccessFile.writeInt(averageDistanceInKMTravelledToFixedPlaceOfWork);
                aRandomAccessFile.writeInt(publicTransportUsersInHouseholdsWithACarOrVan);
                aRandomAccessFile.writeInt(publicTransportUsersInHouseholdsWithoutACarOrVan);
            } catch (IOException aIOException) {
                System.err.println(aIOException.getLocalizedMessage());
                System.exit(Generic_ErrorAndExceptionHandler.IOException);
            }
        } else {
            write(aRandomAccessFile);
        }
    }

    /**
     * @return An aggregated <code>Census_CASKS015DataRecord</code> where:
     *         <code>RecordID = this.RecordID</code>
     *         <code>Zone_Code = this.Zone_Code</code> For aggregating
     *         <code>CASKS015DataRecords</code>. User needs to take care in
     *         aggregating to ensure aggregation does not compromise (introduce
     *         error) based on the numbers used (i.e. numbers may not be precise
     *         or have sufficient magnitude).
     * @param aCASKS015DataRecord
     *            The <code>Census_CASKS015DataRecord</code> to be aggregated with
     *            <code>this</code>.
     */
    public Census_CASKS015DataRecord aggregate(Census_CASKS015DataRecord aCASKS015DataRecord) {
        Census_CASKS015DataRecord newCASKS015DataRecord = new Census_CASKS015DataRecord(
                aCASKS015DataRecord);
        newCASKS015DataRecord.peopleAged16to74InEmployment += getPeopleAged16to74InEmployment();
        newCASKS015DataRecord.peopleAged16to74InEmploymentWhoWorkMainlyAtOrFromHome += getPeopleAged16to74InEmploymentWhoWorkMainlyAtOrFromHome();
        newCASKS015DataRecord.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByUndergroundMetroLightRailTram += getPeopleAged16to74InEmploymentWhoUsuallyTravelToWorkByUndergroundMetroLightRailTram();
        newCASKS015DataRecord.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTrain += getPeopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTrain();
        newCASKS015DataRecord.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBusMinibusOrCoach += getPeopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBusMinibusOrCoach();
        newCASKS015DataRecord.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByMotorcycleScooterOrMoped += getPeopleAged16to74InEmploymentWhoUsuallyTravelToWorkByMotorcycleScooterOrMoped();
        newCASKS015DataRecord.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByDrivingACarOrVan += getPeopleAged16to74InEmploymentWhoUsuallyTravelToWorkByDrivingACarOrVan();
        newCASKS015DataRecord.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByPassengerInACarOrVan += getPeopleAged16to74InEmploymentWhoUsuallyTravelToWorkByPassengerInACarOrVan();
        newCASKS015DataRecord.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTaxiOrMinicab += getPeopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTaxiOrMinicab();
        newCASKS015DataRecord.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBicycle += getPeopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBicycle();
        newCASKS015DataRecord.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOnFoot += getPeopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOnFoot();
        newCASKS015DataRecord.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOther += getPeopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOther();
        newCASKS015DataRecord.averageDistanceInKMTravelledToFixedPlaceOfWork += getAverageDistanceInKMTravelledToFixedPlaceOfWork();
        newCASKS015DataRecord.publicTransportUsersInHouseholdsWithACarOrVan += getPublicTransportUsersInHouseholdsWithACarOrVan();
        newCASKS015DataRecord.publicTransportUsersInHouseholdsWithoutACarOrVan += getPublicTransportUsersInHouseholdsWithoutACarOrVan();
        return newCASKS015DataRecord;
    }

    /**
     * @return An aggregated <code>Census_CASKS015DataRecord</code> where:
     *         <code>RecordID = newRecordID</code>
     *         <code>Zone_Code = newZone_Code</code> For aggregating
     *         <code>CASKS015DataRecords</code>. User needs to take care in
     *         aggregating to ensure aggregation does not compromise (introduce
     *         error) based on the numbers used (i.e. numbers may not be precise
     *         or have sufficient magnitude).
     * @param aCASKS015DataRecord
     *            The <code>Census_CASKS015DataRecord</code> to be aggregated with
     *            <code>this</code>.
     * @param newRecordID
     *            The <code>RecordID</code> assigned to result.
     * @param newZone_Code
     *            The <code>Zone_Code</code> assigned to result.
     */
    public Census_CASKS015DataRecord aggregate(Census_CASKS015DataRecord aCASKS015DataRecord,
            long newRecordID, char[] newZone_Code) {
        Census_CASKS015DataRecord newCASKS015DataRecord = new Census_CASKS015DataRecord(this);
        newCASKS015DataRecord._RecordID = newRecordID;
        // newCASKS015DataRecord.Zone_Code = aCASKS015DataRecord.Zone_Code;
        int aZone_CodeID = 0;
        for (int Zone_CodeID = 0; Zone_CodeID < newZone_Code.length; Zone_CodeID++) {
            newCASKS015DataRecord.Zone_Code[Zone_CodeID] = newZone_Code[Zone_CodeID];
            aZone_CodeID = Zone_CodeID;
        }
        for (int Zone_CodeID = aZone_CodeID; Zone_CodeID < Zone_Code.length; Zone_CodeID++) {
            newCASKS015DataRecord.Zone_Code[Zone_CodeID] = ' ';
        }
        newCASKS015DataRecord.peopleAged16to74InEmployment += getPeopleAged16to74InEmployment();
        newCASKS015DataRecord.peopleAged16to74InEmploymentWhoWorkMainlyAtOrFromHome += getPeopleAged16to74InEmploymentWhoWorkMainlyAtOrFromHome();
        newCASKS015DataRecord.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByUndergroundMetroLightRailTram += getPeopleAged16to74InEmploymentWhoUsuallyTravelToWorkByUndergroundMetroLightRailTram();
        newCASKS015DataRecord.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTrain += getPeopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTrain();
        newCASKS015DataRecord.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBusMinibusOrCoach += getPeopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBusMinibusOrCoach();
        newCASKS015DataRecord.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByMotorcycleScooterOrMoped += getPeopleAged16to74InEmploymentWhoUsuallyTravelToWorkByMotorcycleScooterOrMoped();
        newCASKS015DataRecord.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByDrivingACarOrVan += getPeopleAged16to74InEmploymentWhoUsuallyTravelToWorkByDrivingACarOrVan();
        newCASKS015DataRecord.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByPassengerInACarOrVan += getPeopleAged16to74InEmploymentWhoUsuallyTravelToWorkByPassengerInACarOrVan();
        newCASKS015DataRecord.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTaxiOrMinicab += getPeopleAged16to74InEmploymentWhoUsuallyTravelToWorkByTaxiOrMinicab();
        newCASKS015DataRecord.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBicycle += getPeopleAged16to74InEmploymentWhoUsuallyTravelToWorkByBicycle();
        newCASKS015DataRecord.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOnFoot += getPeopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOnFoot();
        newCASKS015DataRecord.peopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOther += getPeopleAged16to74InEmploymentWhoUsuallyTravelToWorkByOther();
        newCASKS015DataRecord.averageDistanceInKMTravelledToFixedPlaceOfWork += getAverageDistanceInKMTravelledToFixedPlaceOfWork();
        newCASKS015DataRecord.publicTransportUsersInHouseholdsWithACarOrVan += getPublicTransportUsersInHouseholdsWithACarOrVan();
        newCASKS015DataRecord.publicTransportUsersInHouseholdsWithoutACarOrVan += getPublicTransportUsersInHouseholdsWithoutACarOrVan();
        return newCASKS015DataRecord;
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
        result += (15L * (long) Integer.SIZE) / getNumberOfBitsInByte();
        return result;
    }
}