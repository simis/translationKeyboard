/* Generated by JavaFromJSON */
/*http://javafromjson.dashingrocket.com*/

package org.distantshoresmedia.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import de.greenrobot.dao.DaoException;

public class KeyCharacter {

    static final private String kModeMaskKey = "modmask";
    static final private String kUnicodeValue = "unicode";

    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient KeyCharacterDao myDao;

    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    private String name;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

	private int[] unicodeValue;
 	public void setUnicodeValue(int[] unicodeValue) {
		this.unicodeValue = unicodeValue;
	}
	public int[] getUnicodeValue() {
		return unicodeValue;
	}

	private Integer modMask;
 	public void setModmask(int modMask) {
		this.modMask = modMask;
	}
	public Integer getModmask() {
		return modMask;
	}


    public KeyCharacter(Integer modMask, int[] unicodeValue){
        this.unicodeValue = unicodeValue;
        this.modMask = modMask;
    }


    static public KeyCharacter getCharacterFromJsonObject(JSONObject jsonObj){

        System.out.println("Got to KeyCharacter");

        try {
            int mask = jsonObj.getInt(kModeMaskKey);
            int[] hexes = {jsonObj.getInt(kUnicodeValue)};

//            String[] parts = hexes.split(";");
            KeyCharacter newChar = new KeyCharacter(mask, hexes);
            return newChar;
        }

        catch (JSONException e) {
            System.out.println(" KeyCharacter JsonExcepetion; " + e.toString());
            return null;
        }
    }

    @Override
    public String toString() {
        return "KeyCharacter{" +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", unicodeValue=" + Arrays.toString(unicodeValue) +
                ", modMask=" + modMask +
                '}';
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getKeyCharacterDao() : null;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetVariants() {
//        KeyboardVariant = null;
    }

    /** Convenient call for {@link (Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
//        myDao.delete(this);
    }

    /** Convenient call for {@link(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
//        myDao.update(this);
    }

    /** Convenient call for {@link(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
//        myDao.refresh(this);
    }
}