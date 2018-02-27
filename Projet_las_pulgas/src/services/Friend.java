package services;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

public class Friend {
	public static JSONObject AddFriend(String key, int id_friend) throws JSONException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		return ma_bd.UserTools.AddFriend(key, id_friend);
	}

	public static JSONObject RemoveFriend(String key, int id_friend)
			throws JSONException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		return ma_bd.UserTools.RemoveFriend(key, id_friend);
	}
}