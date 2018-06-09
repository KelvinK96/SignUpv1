package com.example.user.signupv1.data;

import android.provider.BaseColumns;

public class UsersContract {

    public static final class UserEntry implements BaseColumns {

        public static final String TABLE_NAME = "users";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_PASSWORD = "pasword";
    }
}
