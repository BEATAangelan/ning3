package ningjiaxin1.bwie.com.ning_lian;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private Sql sql;
    private SQLiteDatabase database;
    public UserDao(Context context){
        sql = new Sql(context);
        database = sql.getReadableDatabase();
    }
    public void add(String name,String UUid){
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("UUid",UUid);
        database.insert("user",null,values);
    }
    public List<UserBean> select(){
        Cursor query = database.query("user", null, null, null, null, null, null);
        ArrayList<UserBean> list=new ArrayList();
        while(query.moveToNext()){
            String name = query.getString(query.getColumnIndex("name"));
            String uUid = query.getString(query.getColumnIndex("UUid"));
            UserBean userBean = new UserBean(name,uUid);
            list.add(userBean);
        }
        return list;
    }
}
