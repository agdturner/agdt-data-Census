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
 * For representing CASKS006DataRecords and providing safe access to the data.
 */
public class Census_CASKS006DataRecord extends Census_AbstractDataRecord {

    /*
     * Ethnic group: All people NB: This table contains counts of Persons
     */
    /**
     * KS0060001 = allPeople
     */
    protected int allPeople;
    /**
     * KS0060002 = whiteWhiteBritish
     */
    protected int whiteWhiteBritish;
    /**
     * KS0060003 = whiteWhiteIrish
     */
    protected int whiteWhiteIrish;
    /**
     * KS0060004 = whiteOtherWhite
     */
    protected int whiteOtherWhite;
    /**
     * KS0060005 = mixedWhiteAndBlackCarribean
     */
    protected int mixedWhiteAndBlackCarribean;
    /**
     * KS0060006 = mixedWhiteAndBlackAfrican
     */
    protected int mixedWhiteAndBlackAfrican;
    /**
     * KS0060007 = mixedWhiteAndAsian
     */
    protected int mixedWhiteAndAsian;
    /**
     * KS0060008 = mixedOtherWhite
     */
    protected int mixedOtherWhite;
    /**
     * KS0060009 = asianOrAsianBritishIndian
     */
    protected int asianOrAsianBritishIndian;
    /**
     * KS0060010 = asianOrAsianBritishPakistani
     */
    protected int asianOrAsianBritishPakistani;
    /**
     * KS0060011 = asianOrAsianBritishBangledeshi
     */
    protected int asianOrAsianBritishBangledeshi;
    /**
     * KS0060012 = asianOrAsianBritishOtherAsian
     */
    protected int asianOrAsianBritishOtherAsian;
    /**
     * KS0060013 = blackOrBlackBritishCaribbean
     */
    protected int blackOrBlackBritishCaribbean;
    /**
     * KS0060014 = blackOrBlackBritishAfrican
     */
    protected int blackOrBlackBritishAfrican;
    /**
     * KS0060015 = blackOrBlackBritishOtherBlack
     */
    protected int blackOrBlackBritishOtherBlack;
    /**
     * KS0060016 = chineseOrOtherEthnicGroupChinese
     */
    protected int chineseOrOtherEthnicGroupChinese;
    /**
     * KS0060017 = chineseOrOtherEthnicGroupOtherEthnicGroup
     */
    protected int chineseOrOtherEthnicGroupOtherEthnicGroup;

    /** Creates a new CASKS006Record */
    public Census_CASKS006DataRecord() {
        _Init();
    }

    /**
     * Creates a new CASKS006DataRecord cloned from aCASKS006DataRecord
     *
     * @param aCASKS006DataRecord
     *            The CASKS006DataRecord from which this is cloned.
     */
    public Census_CASKS006DataRecord(Census_CASKS006DataRecord aCASKS006DataRecord) {
        init(aCASKS006DataRecord);
    }

    /**
     * Creates a new CASKS006DataRecord
     *
     * @param initZero
     *            To ensure initZero() is used instead of _Init()
     */
    public Census_CASKS006DataRecord(boolean initZero) {
        initZero();
    }

    /**
     * Creates a new CASKS006DataRecord
     *
     * @param RecordID
     *            The RecordID to be assigned to this
     * @param line
     *            The Comma Seperated Value <code>String</code>
     * @throws java.io.IOException
     */
    public Census_CASKS006DataRecord(long RecordID, String line) throws IOException {
        String[] fieldsDummy = line.split(",");
        // System.out.println(fieldsDummy.length);
        // for (int i = 0; i < fieldsDummy.length; i ++ ){
        // System.out.println(fieldsDummy[i]);
        // }
        String[] fields = new String[18];
        for (int i = 0; i < fields.length; i++) {
            fields[i] = "";
        }
        System.arraycopy(fieldsDummy, 0, fields, 0, fields.length);
        this._RecordID = RecordID;
        this.Zone_Code = fields[0].substring(1, 11).toCharArray();
        // From Table KS006
        this.allPeople = StaticConverter.to_int(fields[1]);
        this.whiteWhiteBritish = StaticConverter.to_int(fields[2]);
        this.whiteWhiteIrish = StaticConverter.to_int(fields[3]);
        this.whiteOtherWhite = StaticConverter.to_int(fields[4]);
        this.mixedWhiteAndBlackCarribean = StaticConverter.to_int(fields[5]);
        this.mixedWhiteAndBlackAfrican = StaticConverter.to_int(fields[6]);
        this.mixedWhiteAndAsian = StaticConverter.to_int(fields[7]);
        this.mixedOtherWhite = StaticConverter.to_int(fields[8]);
        this.asianOrAsianBritishIndian = StaticConverter.to_int(fields[9]);
        this.asianOrAsianBritishPakistani = StaticConverter.to_int(fields[10]);
        this.asianOrAsianBritishBangledeshi = StaticConverter.to_int(fields[11]);
        this.asianOrAsianBritishOtherAsian = StaticConverter.to_int(fields[12]);
        this.blackOrBlackBritishCaribbean = StaticConverter.to_int(fields[13]);
        this.blackOrBlackBritishAfrican = StaticConverter.to_int(fields[14]);
        this.blackOrBlackBritishOtherBlack = StaticConverter.to_int(fields[15]);
        this.chineseOrOtherEthnicGroupChinese = StaticConverter.to_int(fields[16]);
        this.chineseOrOtherEthnicGroupOtherEthnicGroup = StaticConverter.to_int(fields[17]);
    }

    /**
     * Creates a new CASKS006Record
     *
     * @param aRandomAccessFile
     */
    public Census_CASKS006DataRecord(RandomAccessFile aRandomAccessFile) {
        try {
            this._RecordID = aRandomAccessFile.readLong();
            this.Zone_Code = new char[10];
            for (int i = 0; i < this.Zone_Code.length; i++) {
                Zone_Code[i] = aRandomAccessFile.readChar();
            }
            this.allPeople = aRandomAccessFile.readInt();
            this.whiteWhiteBritish = aRandomAccessFile.readInt();
            this.whiteWhiteIrish = aRandomAccessFile.readInt();
            this.whiteOtherWhite = aRandomAccessFile.readInt();
            this.mixedWhiteAndBlackCarribean = aRandomAccessFile.readInt();
            this.mixedWhiteAndBlackAfrican = aRandomAccessFile.readInt();
            this.mixedWhiteAndAsian = aRandomAccessFile.readInt();
            this.mixedOtherWhite = aRandomAccessFile.readInt();
            this.asianOrAsianBritishIndian = aRandomAccessFile.readInt();
            this.asianOrAsianBritishPakistani = aRandomAccessFile.readInt();
            this.asianOrAsianBritishBangledeshi = aRandomAccessFile.readInt();
            this.asianOrAsianBritishOtherAsian = aRandomAccessFile.readInt();
            this.blackOrBlackBritishCaribbean = aRandomAccessFile.readInt();
            this.blackOrBlackBritishAfrican = aRandomAccessFile.readInt();
            this.blackOrBlackBritishOtherBlack = aRandomAccessFile.readInt();
            this.chineseOrOtherEthnicGroupChinese = aRandomAccessFile.readInt();
            this.chineseOrOtherEthnicGroupOtherEthnicGroup = aRandomAccessFile.readInt();
        } catch (IOException ioe0) {
            ioe0.printStackTrace();
        }
    }

    /**
     * Initialises.
     * @param aCASKS006DataRecord
     */
    protected void init(Census_CASKS006DataRecord aCASKS006DataRecord) {
        super._Init();
        this.allPeople = aCASKS006DataRecord.allPeople;
        this.whiteWhiteBritish = aCASKS006DataRecord.whiteWhiteBritish;
        this.whiteWhiteIrish = aCASKS006DataRecord.whiteWhiteIrish;
        this.whiteOtherWhite = aCASKS006DataRecord.whiteOtherWhite;
        this.mixedWhiteAndBlackCarribean = aCASKS006DataRecord.mixedWhiteAndBlackCarribean;
        this.mixedWhiteAndBlackAfrican = aCASKS006DataRecord.mixedWhiteAndBlackAfrican;
        this.mixedWhiteAndAsian = aCASKS006DataRecord.mixedWhiteAndAsian;
        this.mixedOtherWhite = aCASKS006DataRecord.mixedOtherWhite;
        this.asianOrAsianBritishIndian = aCASKS006DataRecord.asianOrAsianBritishIndian;
        this.asianOrAsianBritishPakistani = aCASKS006DataRecord.asianOrAsianBritishPakistani;
        this.asianOrAsianBritishBangledeshi = aCASKS006DataRecord.asianOrAsianBritishBangledeshi;
        this.asianOrAsianBritishOtherAsian = aCASKS006DataRecord.asianOrAsianBritishOtherAsian;
        this.blackOrBlackBritishCaribbean = aCASKS006DataRecord.blackOrBlackBritishCaribbean;
        this.blackOrBlackBritishAfrican = aCASKS006DataRecord.blackOrBlackBritishAfrican;
        this.blackOrBlackBritishOtherBlack = aCASKS006DataRecord.blackOrBlackBritishOtherBlack;
        this.chineseOrOtherEthnicGroupChinese = aCASKS006DataRecord.chineseOrOtherEthnicGroupChinese;
        this.chineseOrOtherEthnicGroupOtherEthnicGroup = aCASKS006DataRecord.chineseOrOtherEthnicGroupOtherEthnicGroup;
    }

    /**
     * Initialises.
     */
    protected void _Init() {
        super._Init();
        this.allPeople = Integer.MIN_VALUE;
        this.whiteWhiteBritish = Integer.MIN_VALUE;
        this.whiteWhiteIrish = Integer.MIN_VALUE;
        this.whiteOtherWhite = Integer.MIN_VALUE;
        this.mixedWhiteAndBlackCarribean = Integer.MIN_VALUE;
        this.mixedWhiteAndBlackAfrican = Integer.MIN_VALUE;
        this.mixedWhiteAndAsian = Integer.MIN_VALUE;
        this.mixedOtherWhite = Integer.MIN_VALUE;
        this.asianOrAsianBritishIndian = Integer.MIN_VALUE;
        this.asianOrAsianBritishPakistani = Integer.MIN_VALUE;
        this.asianOrAsianBritishBangledeshi = Integer.MIN_VALUE;
        this.asianOrAsianBritishOtherAsian = Integer.MIN_VALUE;
        this.blackOrBlackBritishCaribbean = Integer.MIN_VALUE;
        this.blackOrBlackBritishAfrican = Integer.MIN_VALUE;
        this.blackOrBlackBritishOtherBlack = Integer.MIN_VALUE;
        this.chineseOrOtherEthnicGroupChinese = Integer.MIN_VALUE;
        this.chineseOrOtherEthnicGroupOtherEthnicGroup = Integer.MIN_VALUE;
    }

    /**
     * Initialises to zero.
     */
    protected void initZero() {
        super._Init();
        this.allPeople = 0;
        this.whiteWhiteBritish = 0;
        this.whiteWhiteIrish = 0;
        this.whiteOtherWhite = 0;
        this.mixedWhiteAndBlackCarribean = 0;
        this.mixedWhiteAndBlackAfrican = 0;
        this.mixedWhiteAndAsian = 0;
        this.mixedOtherWhite = 0;
        this.asianOrAsianBritishIndian = 0;
        this.asianOrAsianBritishPakistani = 0;
        this.asianOrAsianBritishBangledeshi = 0;
        this.asianOrAsianBritishOtherAsian = 0;
        this.blackOrBlackBritishCaribbean = 0;
        this.blackOrBlackBritishAfrican = 0;
        this.blackOrBlackBritishOtherBlack = 0;
        this.chineseOrOtherEthnicGroupChinese = 0;
        this.chineseOrOtherEthnicGroupOtherEthnicGroup = 0;
    }

    /**
     * Returns a string description of this;
     * @return 
     */
    public String toString() {
        return super.toString() + ", allPeople " + allPeople + ", whiteWhiteBritish " + whiteWhiteBritish + ", whiteWhiteIrish " + whiteWhiteIrish + ", whiteOtherWhite " + whiteOtherWhite + ", mixedWhiteAndBlackCarribean " + mixedWhiteAndBlackCarribean + ", mixedWhiteAndBlackAfrican " + mixedWhiteAndBlackAfrican + ", mixedWhiteAndAsian " + mixedWhiteAndAsian + ", mixedOtherWhite " + mixedOtherWhite + ", asianOrAsianBritishIndian " + asianOrAsianBritishIndian + ", asianOrAsianBritishPakistani " + asianOrAsianBritishPakistani + ", asianOrAsianBritishBangledeshi " + asianOrAsianBritishBangledeshi + ", asianOrAsianBritishOtherAsian " + asianOrAsianBritishOtherAsian + ", blackOrBlackBritishCaribbean " + blackOrBlackBritishCaribbean + ", blackOrBlackBritishAfrican " + blackOrBlackBritishAfrican + ", blackOrBlackBritishOtherBlack " + blackOrBlackBritishOtherBlack + ", chineseOrOtherEthnicGroupChinese " + chineseOrOtherEthnicGroupChinese + ", chineseOrOtherEthnicGroupOtherEthnicGroup " + chineseOrOtherEthnicGroupOtherEthnicGroup;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the values
     *         of the <code>Fields</code> of <code>this</code>.
     */
    @Override
    public String toCSVString() {
        String result = super.toCSVString();
        result += "," + this.allPeople;
        result += "," + this.whiteWhiteBritish;
        result += "," + this.whiteWhiteIrish;
        result += "," + this.whiteOtherWhite;
        result += "," + this.mixedWhiteAndBlackCarribean;
        result += "," + this.mixedWhiteAndBlackAfrican;
        result += "," + this.mixedWhiteAndAsian;
        result += "," + this.mixedOtherWhite;
        result += "," + this.asianOrAsianBritishIndian;
        result += "," + this.asianOrAsianBritishPakistani;
        result += "," + this.asianOrAsianBritishBangledeshi;
        result += "," + this.asianOrAsianBritishOtherAsian;
        result += "," + this.blackOrBlackBritishCaribbean;
        result += "," + this.blackOrBlackBritishAfrican;
        result += "," + this.blackOrBlackBritishOtherBlack;
        result += "," + this.chineseOrOtherEthnicGroupChinese;
        result += "," + this.chineseOrOtherEthnicGroupOtherEthnicGroup;
        return result;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the names
     *         of the <code>Fields</code> of <code>this</code>
     */
    @Override
    public String toCSVStringFields() {
        String result = super.toCSVStringFields();
        result += ",allPeople";
        result += ",whiteWhiteBritish";
        result += ",whiteWhiteIrish";
        result += ",whiteOtherWhite";
        result += ",mixedWhiteAndBlackCarribean";
        result += ",mixedWhiteAndBlackAfrican";
        result += ",mixedWhiteAndAsian";
        result += ",mixedOtherWhite";
        result += ",asianOrAsianBritishIndian";
        result += ",asianOrAsianBritishPakistani";
        result += ",asianOrAsianBritishBangledeshi";
        result += ",asianOrAsianBritishOtherAsian";
        result += ",blackOrBlackBritishCaribbean";
        result += ",blackOrBlackBritishAfrican";
        result += ",blackOrBlackBritishOtherBlack";
        result += ",chineseOrOtherEthnicGroupChinese";
        result += ",chineseOrOtherEthnicGroupOtherEthnicGroup";
        return result;
    }

    /**
     * Returns a copy of this.allPeople
     * @return 
     */
    public int getAllPeople() {
        return this.allPeople;
    }

    /**
     * Returns a copy of this.whiteWhiteBritish
     * @return 
     */
    public int getWhiteWhiteBritish() {
        return this.whiteWhiteBritish;
    }

    /**
     * Returns a copy of this.whiteWhiteIrish
     * @return 
     */
    public int getWhiteWhiteIrish() {
        return this.whiteWhiteIrish;
    }

    /**
     * Returns a copy of this.whiteOtherWhite
     * @return 
     */
    public int getWhiteOtherWhite() {
        return this.whiteOtherWhite;
    }

    /**
     * Returns a copy of this.mixedWhiteAndBlackCarribean
     * @return 
     */
    public int getMixedWhiteAndBlackCarribean() {
        return this.mixedWhiteAndBlackCarribean;
    }

    /**
     * Returns a copy of this.mixedWhiteAndBlackAfrican
     * @return 
     */
    public int getMixedWhiteAndBlackAfrican() {
        return this.mixedWhiteAndBlackAfrican;
    }

    /**
     * Returns a copy of this.mixedWhiteAndAsian
     * @return 
     */
    public int getMixedWhiteAndAsian() {
        return this.mixedWhiteAndAsian;
    }

    /**
     * Returns a copy of this.mixedOtherWhite
     * @return 
     */
    public int getMixedOtherWhite() {
        return this.mixedOtherWhite;
    }

    /**
     * Returns a copy of this.asianOrAsianBritishIndian
     * @return 
     */
    public int getAsianOrAsianBritishIndian() {
        return this.asianOrAsianBritishIndian;
    }

    /**
     * Returns a copy of this.asianOrAsianBritishPakistani
     * @return 
     */
    public int getAsianOrAsianBritishPakistani() {
        return this.asianOrAsianBritishPakistani;
    }

    /**
     * Returns a copy of this.asianOrAsianBritishBangledeshi
     * @return 
     */
    public int getAsianOrAsianBritishBangledeshi() {
        return this.asianOrAsianBritishBangledeshi;
    }

    /**
     * Returns a copy of this.asianOrAsianBritishOtherAsian
     * @return 
     */
    public int getAsianOrAsianBritishOtherAsian() {
        return this.asianOrAsianBritishOtherAsian;
    }

    /**
     * Returns a copy of this.blackOrBlackBritishCaribbean
     * @return 
     */
    public int getBlackOrBlackBritishCaribbean() {
        return this.blackOrBlackBritishCaribbean;
    }

    /**
     * Returns a copy of this.blackOrBlackBritishAfrican
     * @return 
     */
    public int getBlackOrBlackBritishAfrican() {
        return this.blackOrBlackBritishAfrican;
    }

    /**
     * Returns a copy of this.blackOrBlackBritishOtherBlack
     * @return 
     */
    public int getBlackOrBlackBritishOtherBlack() {
        return this.blackOrBlackBritishOtherBlack;
    }

    /**
     * Returns a copy of this.chineseOrOtherEthnicGroupOtherEthnicGroup
     * @return 
     */
    public int getChineseOrOtherEthnicGroupOtherEthnicGroup() {
        return this.chineseOrOtherEthnicGroupOtherEthnicGroup;
    }

    /**
     * Returns a copy of this.chineseOrOtherEthnicGroupChinese
     * @return 
     */
    public int getChineseOrOtherEthnicGroupChinese() {
        return this.chineseOrOtherEthnicGroupChinese;
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
                aRandomAccessFile.writeInt(this.allPeople);
                aRandomAccessFile.writeInt(this.whiteWhiteBritish);
                aRandomAccessFile.writeInt(this.whiteWhiteIrish);
                aRandomAccessFile.writeInt(this.whiteOtherWhite);
                aRandomAccessFile.writeInt(this.mixedWhiteAndBlackCarribean);
                aRandomAccessFile.writeInt(this.mixedWhiteAndBlackAfrican);
                aRandomAccessFile.writeInt(this.mixedWhiteAndAsian);
                aRandomAccessFile.writeInt(this.mixedOtherWhite);
                aRandomAccessFile.writeInt(this.asianOrAsianBritishIndian);
                aRandomAccessFile.writeInt(this.asianOrAsianBritishPakistani);
                aRandomAccessFile.writeInt(this.asianOrAsianBritishBangledeshi);
                aRandomAccessFile.writeInt(this.asianOrAsianBritishOtherAsian);
                aRandomAccessFile.writeInt(this.blackOrBlackBritishCaribbean);
                aRandomAccessFile.writeInt(this.blackOrBlackBritishAfrican);
                aRandomAccessFile.writeInt(this.blackOrBlackBritishOtherBlack);
                aRandomAccessFile.writeInt(this.chineseOrOtherEthnicGroupChinese);
                aRandomAccessFile.writeInt(this.chineseOrOtherEthnicGroupOtherEthnicGroup);
            } catch (IOException aIOException) {
                System.err.println(aIOException.getLocalizedMessage());
                System.exit(Generic_ErrorAndExceptionHandler.IOException);
            }
        } else {
            write(aRandomAccessFile);
        }
    }

    /**
     * @return An aggregated <code>Census_CASKS006DataRecord</code> where:
     *         <code>RecordID = newRecordID</code>
     *         <code>Zone_Code = newZone_Code</code> For aggregating
     *         <code>CASKS006DataRecords</code>. User needs to take care in
     *         aggregating to ensure aggregation does not compromise (introduce
     *         error) based on the numbers used (i.e. numbers may not be precise
     *         or have sufficient magnitude).
     * @param aCASKS006DataRecord
     *            The <code>Census_CASKS006DataRecord</code> to be aggregated with
     *            <code>this</code>.
     */
    public Census_CASKS006DataRecord aggregate(Census_CASKS006DataRecord aCASKS006DataRecord) {
        Census_CASKS006DataRecord newCASKS006DataRecord = new Census_CASKS006DataRecord(
                aCASKS006DataRecord);
        newCASKS006DataRecord.allPeople += getAllPeople();
        newCASKS006DataRecord.whiteWhiteBritish += getWhiteWhiteBritish();
        newCASKS006DataRecord.whiteWhiteIrish += getWhiteWhiteIrish();
        newCASKS006DataRecord.whiteOtherWhite += getWhiteOtherWhite();
        newCASKS006DataRecord.mixedWhiteAndBlackCarribean += getMixedWhiteAndBlackCarribean();
        newCASKS006DataRecord.mixedWhiteAndBlackAfrican += getMixedWhiteAndBlackAfrican();
        newCASKS006DataRecord.mixedWhiteAndAsian += getMixedWhiteAndAsian();
        newCASKS006DataRecord.mixedOtherWhite += getMixedOtherWhite();
        newCASKS006DataRecord.asianOrAsianBritishIndian += getAsianOrAsianBritishIndian();
        newCASKS006DataRecord.asianOrAsianBritishPakistani += getAsianOrAsianBritishPakistani();
        newCASKS006DataRecord.asianOrAsianBritishBangledeshi += getAsianOrAsianBritishBangledeshi();
        newCASKS006DataRecord.asianOrAsianBritishOtherAsian += getAsianOrAsianBritishOtherAsian();
        newCASKS006DataRecord.blackOrBlackBritishCaribbean += getBlackOrBlackBritishCaribbean();
        newCASKS006DataRecord.blackOrBlackBritishAfrican += getBlackOrBlackBritishAfrican();
        newCASKS006DataRecord.blackOrBlackBritishOtherBlack += getBlackOrBlackBritishOtherBlack();
        newCASKS006DataRecord.chineseOrOtherEthnicGroupChinese += getChineseOrOtherEthnicGroupChinese();
        newCASKS006DataRecord.chineseOrOtherEthnicGroupOtherEthnicGroup += getChineseOrOtherEthnicGroupOtherEthnicGroup();
        return newCASKS006DataRecord;
    }

    /**
     * @return An aggregated <code>Census_CASKS006DataRecord</code> where:
     *         <code>RecordID = newRecordID</code>
     *         <code>Zone_Code = newZone_Code</code> For aggregating
     *         <code>CASKS006DataRecords</code>. User needs to take care in
     *         aggregating to ensure aggregation does not compromise (introduce
     *         error) based on the numbers used (i.e. numbers may not be precise
     *         or have sufficient magnitude).
     * @param aCASKS006DataRecord
     *            The <code>Census_CASKS006DataRecord</code> to be aggregated with
     *            <code>this</code>.
     * @param newRecordID
     *            The <code>RecordID</code> assigned to result.
     * @param newZone_Code
     *            The <code>Zone_Code</code> assigned to result.
     */
    public Census_CASKS006DataRecord aggregate(Census_CASKS006DataRecord aCASKS006DataRecord,
            long newRecordID, char[] newZone_Code) {
        Census_CASKS006DataRecord newCASKS006DataRecord = new Census_CASKS006DataRecord(this);
        newCASKS006DataRecord._RecordID = newRecordID;
        // newCASKS006DataRecord.Zone_Code = aCASKS006DataRecord.Zone_Code;
        int aZone_CodeID = 0;
        for (int Zone_CodeID = 0; Zone_CodeID < newZone_Code.length; Zone_CodeID++) {
            newCASKS006DataRecord.Zone_Code[Zone_CodeID] = newZone_Code[Zone_CodeID];
            aZone_CodeID = Zone_CodeID;
        }
        for (int Zone_CodeID = aZone_CodeID; Zone_CodeID < Zone_Code.length; Zone_CodeID++) {
            newCASKS006DataRecord.Zone_Code[Zone_CodeID] = ' ';
        }
        newCASKS006DataRecord.allPeople += getAllPeople();
        newCASKS006DataRecord.whiteWhiteBritish += getWhiteWhiteBritish();
        newCASKS006DataRecord.whiteWhiteIrish += getWhiteWhiteIrish();
        newCASKS006DataRecord.whiteOtherWhite += getWhiteOtherWhite();
        newCASKS006DataRecord.mixedWhiteAndBlackCarribean += getMixedWhiteAndBlackCarribean();
        newCASKS006DataRecord.mixedWhiteAndBlackAfrican += getMixedWhiteAndBlackAfrican();
        newCASKS006DataRecord.mixedWhiteAndAsian += getMixedWhiteAndAsian();
        newCASKS006DataRecord.mixedOtherWhite += getMixedOtherWhite();
        newCASKS006DataRecord.asianOrAsianBritishIndian += getAsianOrAsianBritishIndian();
        newCASKS006DataRecord.asianOrAsianBritishPakistani += getAsianOrAsianBritishPakistani();
        newCASKS006DataRecord.asianOrAsianBritishBangledeshi += getAsianOrAsianBritishBangledeshi();
        newCASKS006DataRecord.asianOrAsianBritishOtherAsian += getAsianOrAsianBritishOtherAsian();
        newCASKS006DataRecord.blackOrBlackBritishCaribbean += getBlackOrBlackBritishCaribbean();
        newCASKS006DataRecord.blackOrBlackBritishAfrican += getBlackOrBlackBritishAfrican();
        newCASKS006DataRecord.blackOrBlackBritishOtherBlack += getBlackOrBlackBritishOtherBlack();
        newCASKS006DataRecord.chineseOrOtherEthnicGroupChinese += getChineseOrOtherEthnicGroupChinese();
        newCASKS006DataRecord.chineseOrOtherEthnicGroupOtherEthnicGroup += getChineseOrOtherEthnicGroupOtherEthnicGroup();
        return newCASKS006DataRecord;
    }

    /**
     * Returns the size of this Record in bytes as a long. This does not account
     * for serialVersionUID. A boolean is assumed to be the same size as an int
     * in bytes.
     * @return 
     */
    public long getSizeInBytes() {
        long result = super.getSizeInBytes();
        result += (17L * (long) Integer.SIZE) / getNumberOfBitsInByte();
        return result;
    }
}