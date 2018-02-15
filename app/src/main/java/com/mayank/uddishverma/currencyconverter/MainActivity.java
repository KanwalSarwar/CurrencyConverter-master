package com.mayank.uddishverma.currencyconverter;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mayank.uddishverma.currencyconverter.rest.Data;
import com.mayank.uddishverma.currencyconverter.utils.Globals;
import com.mayank.uddishverma.currencyconverter.utils.Prefs;
import com.mayank.uddishverma.currencyconverter.utils.RelativeLayoutTouchListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {



    //*169 currencies name*
    //   String[] dataArray = new String[]{"United Arab Emirates Dirham","Afghan Afghani","Albanian Lek","Armenian Dram","Netherlands Antillean Guilder","Angolan Kwanza","Argentine Peso","Australian Dollar","Aruban Florin","Azerbaijani Manat","Bosnia-Herzegovina Convertible Mark","Barbadian Dollar","Bangladeshi Taka","Bulgarian Lev","Bahraini Dinar","Burundian Franc","Bermudan Dollar","Brunei Dollar","Bolivian Boliviano","Brazilian Real","Bahamian Dollar","Bitcoin","Bhutanese Ngultrum","Botswanan Pula","Belarusian Ruble","Belarus Ruble","Belize Dollar","Canadian Dollar","Congolese Franc","Swiss Franc","Chilean Unidad de Fomento","Chilean Peso","Chinese Yuan","Colombian Peso","Costa Rican ColÃ³n","Cuban Convertible Peso","Cuban Peso","Cape Verdean Escudo","Czech Koruna","Djiboutian Franc","Danish Krone","Dominican Peso","Algerian Dinar","Estonian Kroon","Egyptian Pound","Eritrean Nakfa","Ethiopian Birr","Euro","Fijian Dollar","Falkland Islands Pound","British Pound","Georgian Lari","Guernsey Pound","Ghanaian Cedi","Gibraltar Pound","Gambian Dalasi","Guinean Franc","Guatemalan Quetzal","Guyanaese Dollar","Hong Kong Dollar","Honduran Lempira","Croatian Kuna","Haitian Gourde","Hungarian Forint","Indonesian Rupiah","Israeli New Shekel","Isle of Man Pound","Indian Rupee","Iraqi Dinar","Iranian Rial","Icelandic KrÃ³na","Jersey Pound","Jamaican Dollar","Jordanian Dinar","Japanese Yen","Kenyan Shilling","Kyrgystani Som","Cambodian Riel","Comorian Franc","North Korean Won","South Korean Won","Kuwaiti Dinar","Cayman Islands Dollar","Kazakhstani Tenge","Laotian Kip","Lebanese Pound","Sri Lankan Rupee","Liberian Dollar","Lesotho Loti","Lithuanian Litas","Latvian Lats","Libyan Dinar","Moroccan Dirham","Moldovan Leu","Malagasy Ariary","Macedonian Denar","Myanmar Kyat","Mongolian Tugrik","Macanese Pataca","Mauritanian Ouguiya","Mauritian Rupee","Maldivian Rufiyaa","Malawian Kwacha","Mexican Peso","Malaysian Ringgit","New Mozambican Metical","Namibian Dollar","Nigerian Naira","Nicaraguan CÃ³rdoba","Norwegian Krone","Nepalese","New Zealand Dollar","Omani Rial","Panamanian Balboa","Peruvian Sol","Papua New Guinea Kina","Philippine Piso","Pakistani Rupee","Polish Zloty","Paraguayan Guarani","Qatari Rial","Romanian Leu","Serbian Dinar","Russian Ruble","Rwandan Franc","Saudi Riyal","Solomon Islands Dollar","Seychellois Rupee","Sudanese Pound","Swedish Krona","Singapore Dollar","St. Helena Pound","Sierra Leonean Leone","Somali Shilling","Surinamese Dollar","SÃ£o TomÃ© & PrÃ­ncipe Dobra","Salvadoran ColÃ³n","Syrian Pound","Swazi Lilangeni","Thai Baht","Tajikistani Somoni","Turkmenistani Manat","Tunisian Dinar","Tongan PaÊ»anga","Turkish Lira","Trinidad & Tobago Dollar","New Taiwan Dollar","Tanzanian Shilling","Ukrainian Hryvnia","Ugandan Shilling","US Dollar","Uruguayan Peso","Uzbekistani Som","Venezuelan BolÃ­var","Vietnamese Dong","Vanuatu Vatu","Samoan Tala","Central African CFA Franc","Silver Ounce","Gold Ounce","East Caribbean Dollar","Special Drawing Rights","West African CFA Franc","CFP Franc","Yemeni Rial","South African Rand","Zambian Kwacha","Zambia Kwacha","Zimbabwean Dollar"};


      //displaying somehow right result
 //   String[] dataArray = new String[]{"United Arab Emirates Dirham","Afghan Afghani","Albanian Lek","Armenian Dram","Netherlands Antillean Guilder","Angolan Kwanza","Argentine Peso","Australian Dollar","Aruban Florin","Azerbaijani Manat","Bosnia-Herzegovina Convertible Mark","Barbadian Dollar","Bangladeshi Taka","Bulgarian Lev","Bahraini Dinar","Burundian Franc","Bermudan Dollar","Brunei Dollar","Bolivian Boliviano","Brazilian Real","Bahamian Dollar","Bitcoin","Bhutanese Ngultrum","Botswanan Pula","Belarusian Ruble","Belarus Ruble","Belize Dollar","Canadian Dollar","Congolese Franc","Swiss Franc","Chilean Unidad de Fomento","Chilean Peso","Chinese Yuan","Colombian Peso","Costa Rican ColÃ³n","Cuban Convertible Peso","Cuban Peso","Cape Verdean Escudo","Czech Koruna","Djiboutian Franc","Danish Krone","Dominican Peso","Algerian Dinar","Estonian Kroon","Egyptian Pound","Eritrean Nakfa","Ethiopian Birr","Euro","Fijian Dollar","Falkland Islands Pound","British Pound","Georgian Lari","Guernsey Pound","Ghanaian Cedi","Gibraltar Pound","Gambian Dalasi","Guinean Franc","Guatemalan Quetzal","Guyanaese Dollar","Hong Kong Dollar","Honduran Lempira","Croatian Kuna","Haitian Gourde","Hungarian Forint","Indonesian Rupiah","Israeli New Shekel","Isle of Man Pound","Indian Rupee","Iraqi Dinar","Iranian Rial","Icelandic KrÃ³na","Jersey Pound","Jamaican Dollar","Jordanian Dinar","Japanese Yen","Kenyan Shilling","Kyrgystani Som","Cambodian Riel","Comorian Franc","North Korean Won","South Korean Won","Kuwaiti Dinar","Cayman Islands Dollar","Kazakhstani Tenge","Laotian Kip","Lebanese Pound","Sri Lankan Rupee","Liberian Dollar","Lesotho Loti","Lithuanian Litas","Latvian Lats","Libyan Dinar","Moroccan Dirham","Moldovan Leu","Malagasy Ariary","Macedonian Denar","Myanmar Kyat","Mongolian Tugrik","Macanese Pataca","Mauritanian Ouguiya","Mauritian Rupee","Maldivian Rufiyaa","Malawian Kwacha","Mexican Peso","Malaysian Ringgit","New Mozambican Metical","Namibian Dollar","Nigerian Naira","Nicaraguan CÃ³rdoba","Norwegian Krone","Nepalese","New Zealand Dollar","Omani Rial","Panamanian Balboa","Peruvian Sol","Papua New Guinea Kina","Philippine Piso","Pakistani Rupee","Polish Zloty","Paraguayan Guarani","Qatari Rial","Romanian Leu","Serbian Dinar","Russian Ruble","Rwandan Franc","Saudi Riyal","Solomon Islands Dollar","Seychellois Rupee","Sudanese Pound","Swedish Krona","Singapore Dollar","St. Helena Pound","Sierra Leonean Leone","Somali Shilling","Surinamese Dollar","SÃ£o TomÃ© & PrÃ­ncipe Dobra","Salvadoran ColÃ³n","Syrian Pound","Swazi Lilangeni","Thai Baht","Tajikistani Somoni","Turkmenistani Manat","Tunisian Dinar","Tongan PaÊ»anga","Turkish Lira","Trinidad & Tobago Dollar","New Taiwan Dollar","Tanzanian Shilling","Ukrainian Hryvnia","Ugandan Shilling","US Dollar","Uruguayan Peso","Uzbekistani Som","Venezuelan BolÃ­var","Vietnamese Dong","Vanuatu Vatu","Samoan Tala","Central African CFA Franc","Silver Ounce","Gold Ounce","East Caribbean Dollar","Special Drawing Rights","West African CFA Franc","CFP Franc","Yemeni Rial","South African Rand","Zambian Kwacha","Zambia Kwacha","Zimbabwean Dollar"};



    String[] dataArray = new String[]{"United Arab Emirates Dirham","Afghan Afghani","Albanian Lek","Armenian Dram","Angolan Kwanza","Argentine Peso","Australian Dollar (Australia)","Australian Dollar (Kiribati)","Australian Dollar (Nauru)","Australian Dollar (Tuvalu)","Aruban Guilder","New Azerbaijani Manat","Convertible Mark","Barbados Dollar","Bangladeshi Taka","Bulgarian Lev","Bahraini Dinar","Burundian Franc","Brunei Dollar","Boliviano","Brazilian Real","Bahamian Dollar"," ","Bhutanese Ngultrum","Botswana Pula"," ","Belarusian Ruble","Belize Dollar","Canadian Dollar","Congolese Franc","Swiss Franc (Liechtenstein)","Swiss Franc (Switzerland)"," ","Chilean Peso","Chinese Yuan","Colombian Peso","Costa Rican Colon"," ","Cuban convertible Peso"," ","Czech Koruna","Djiboutian Franc","Danish Krone","Dominican Peso","Algerian Dinar"," ","Egyptian Pound","Eritrean Nakfa","Ethipian Birr","Euro (Finland)","Euro (Luxembourg)","Euro (Portugal)","Euro (Slovenia)","Euro (Spain)","Euro (Estonia)","Euro (Andorra)","Euro (Belgium)","Euro (Malta)","Euro (Austria)","Euro (Cyprus)","Euro (France)","Euro (Germany)","Euro (Italy)","Euro (Montenegro)","Euro (San Marino)","Euro (Greece)","Euro (Ireland)","Euro (Monaco)","Euro (Netherlands)","Euro (Slovakia)","Lithuanian Litas ( -- LT code --  )"                               ,"Aruban Florin","Azerbaijani Manat","Bosnia-Herzegovina Convertible Mark","Barbadian Dollar","Bangladeshi Taka","Bulgarian Lev","Bahraini Dinar","Burundian Franc","Bermudan Dollar","Brunei Dollar","Bolivian Boliviano","Brazilian Real","Bahamian Dollar","Bitcoin","Bhutanese Ngultrum","Botswanan Pula","Belarusian Ruble","Belarus Ruble","Belize Dollar","Canadian Dollar","Congolese Franc","Swiss Franc","Chilean Unidad de Fomento","Chilean Peso","Chinese Yuan","Colombian Peso","Costa Rican ColÃ³n","Cuban Convertible Peso","Cuban Peso","Cape Verdean Escudo","Czech Koruna","Djiboutian Franc","Danish Krone","Dominican Peso","Algerian Dinar","Estonian Kroon","Egyptian Pound","Eritrean Nakfa","Ethiopian Birr","Euro","Fijian Dollar","Falkland Islands Pound","British Pound","Georgian Lari","Guernsey Pound","Ghanaian Cedi","Gibraltar Pound","Gambian Dalasi","Guinean Franc","Guatemalan Quetzal","Guyanaese Dollar","Hong Kong Dollar","Honduran Lempira","Croatian Kuna","Haitian Gourde","Hungarian Forint","Indonesian Rupiah","Israeli New Shekel","Isle of Man Pound","Indian Rupee","Iraqi Dinar","Iranian Rial","Icelandic KrÃ³na","Jersey Pound","Jamaican Dollar","Jordanian Dinar","Japanese Yen","Kenyan Shilling","Kyrgystani Som","Cambodian Riel","Comorian Franc","North Korean Won","South Korean Won","Kuwaiti Dinar","Cayman Islands Dollar","Kazakhstani Tenge","Laotian Kip","Lebanese Pound","Sri Lankan Rupee","Liberian Dollar","Lesotho Loti","Lithuanian Litas","Latvian Lats","Libyan Dinar","Moroccan Dirham","Moldovan Leu","Malagasy Ariary","Macedonian Denar","Myanmar Kyat","Mongolian Tugrik","Macanese Pataca","Mauritanian Ouguiya","Mauritian Rupee","Maldivian Rufiyaa","Malawian Kwacha","Mexican Peso","Malaysian Ringgit","New Mozambican Metical","Namibian Dollar","Nigerian Naira","Nicaraguan CÃ³rdoba","Norwegian Krone","Nepalese","New Zealand Dollar","Omani Rial","Panamanian Balboa","Peruvian Sol","Papua New Guinea Kina","Philippine Piso","Pakistani Rupee","Polish Zloty","Paraguayan Guarani","Qatari Rial","Romanian Leu","Serbian Dinar","Russian Ruble","Rwandan Franc","Saudi Riyal","Solomon Islands Dollar","Seychellois Rupee","Sudanese Pound","Swedish Krona","Singapore Dollar","St. Helena Pound","Sierra Leonean Leone","Somali Shilling","Surinamese Dollar","SÃ£o TomÃ© & PrÃ­ncipe Dobra","Salvadoran ColÃ³n","Syrian Pound","Swazi Lilangeni","Thai Baht","Tajikistani Somoni","Turkmenistani Manat","Tunisian Dinar","Tongan PaÊ»anga","Turkish Lira","Trinidad & Tobago Dollar","New Taiwan Dollar","Tanzanian Shilling","Ukrainian Hryvnia","Ugandan Shilling","US Dollar","Uruguayan Peso","Uzbekistani Som","Venezuelan BolÃ­var","Vietnamese Dong","Vanuatu Vatu","Samoan Tala","Central African CFA Franc","Silver Ounce","Gold Ounce","East Caribbean Dollar","Special Drawing Rights","West African CFA Franc","CFP Franc","Yemeni Rial","South African Rand","Zambian Kwacha","Zambia Kwacha","Zimbabwean Dollar"};




    public static TextView date, currencyTitle, countryTo, countryFrom;
    public static int flag;
    public static EditText currency_from;
    public static TextView currency_to;
    Typeface tfRegular, tfThin;
    public static ImageView arrowDown, arrowUp;
    public static BottomSheetBehavior behavior;
    RecyclerView recyclerView;
    CurrencyAdapter mAdapter;
    ArrayList items = new ArrayList();
    LinearLayout linearLayoutOne, linearLayoutTwo, mainLayout;
    public static RelativeLayout relativeOne, relativeTwo;
    Calendar calendar;
    int screenHeight = 0;
    public static EditText search;
    CardView interchange;
    public static Context ctx;
    public static View line;

    public static final String TAG = "MainActivity";

    public static final String KANWAL = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hiding the status bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initialize();

        ctx = getApplicationContext();

        try {
            if(!(Prefs.getPrefs("country_from",MainActivity.this).equals("notfound"))){
                countryFrom.setText(Prefs.getPrefs("country_from",MainActivity.this));
            }else {
                countryFrom.setText("USD");
            }

            if(!(Prefs.getPrefs("country_to",MainActivity.this).equals("notfound"))){
                countryTo.setText(Prefs.getPrefs("country_to",MainActivity.this));
            }else {
                countryTo.setText("EUR");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        screenHeight = getScreenHeight();

        currencyApi(MainActivity.this);

        Globals.getCountryCode(MainActivity.this);

        //inflating bottom sheet
        final LinearLayout bottomSheet = (LinearLayout) findViewById(R.id.bottom_sheet);
        bottomSheet.getLayoutParams().height = getScreenHeight() - 100;
        behavior = BottomSheetBehavior.from(bottomSheet);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //TODO fill the list
        mAdapter = new CurrencyAdapter(MainActivity.this, Globals.NEWcountryCode, Globals.NEWcountriesCurrencies, Arrays.asList(dataArray));
        recyclerView.setAdapter(mAdapter);

        behavior.setPeekHeight(0);


        Log.d(KANWAL, "getCurrencynames: " + dataArray);


        //Setting click listeners on arrows
        linearLayoutOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = 1;
                behavior.setState(BottomSheetBehavior.STATE_EXPANDED);

                InputMethodManager imm = (InputMethodManager) MainActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(linearLayoutOne.getWindowToken(), 0);
//                behavior.setPeekHeight(screenHeight/2);
            }
        });
        linearLayoutTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = 2;
                behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                InputMethodManager imm = (InputMethodManager) MainActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(linearLayoutTwo.getWindowToken(), 0);
            }
        });

        relativeOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                behavior.setPeekHeight(0);
            }
        });
        relativeTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                behavior.setPeekHeight(0);
            }
        });

        interchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempFrom = String.valueOf(countryFrom.getText());
                countryFrom.setText(countryTo.getText());
                countryTo.setText(tempFrom);

                tempFrom = String.valueOf(currency_from.getText());
                currency_from.setText(currency_to.getText());
                currency_to.setText(tempFrom);

            }
        });

    //    relativeOne.setOnTouchListener(new RelativeLayoutTouchListener(this));

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s != null) {
                    mAdapter.filter(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        currency_from.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s != null && s.length() > 0) {
                    String value = Globals.convertCurrency(countryFrom.getText().toString(), countryTo.getText().toString(), s.toString());
                    currency_to.setText(value.toString());
                }else {
                    currency_to.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        relativeOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) MainActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(relativeOne.getWindowToken(), 0);
            }
        });


    }


    private int getScreenHeight() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        Log.d(TAG, "getScreenHeight: " + height);
        return height;
    }


    private void initialize() {

    //    date = (TextView) findViewById(R.id.date);
        currencyTitle = (TextView) findViewById(R.id.currency_title);
        arrowDown = (ImageView) findViewById(R.id.down_arrow);
        arrowUp = (ImageView) findViewById(R.id.up_arrow);
        countryTo = (TextView) findViewById(R.id.country_to);
        countryFrom = (TextView) findViewById(R.id.country_from);

        interchange = (CardView) findViewById(R.id.interchange);

        currency_from = (EditText) findViewById(R.id.currency_from_et);
        currency_to = (TextView) findViewById(R.id.currency_to_et);

        line = findViewById(R.id.txt_line);

        search = (EditText) findViewById(R.id.search);

   //     date.setText(getCurrentMonth().substring(0, 3) + " " + getCurrentDate() + "," + getCurrentYear());

        relativeOne = (RelativeLayout) findViewById(R.id.relative_1);
        relativeTwo = (RelativeLayout) findViewById(R.id.relative_2);
        linearLayoutOne = (LinearLayout) findViewById(R.id.linearll_1);
        linearLayoutTwo = (LinearLayout) findViewById(R.id.linearll_2);
        mainLayout = (LinearLayout) findViewById(R.id.maine_linear_layout);

        tfRegular = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/OpenSans-Regular.ttf");
        tfRegular = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/Raleway-ExtraLight.ttf");
//        date.setTypeface(tfRegular);
        currencyTitle.setTypeface(tfRegular);
        countryTo.setTypeface(tfThin);
        countryFrom.setTypeface(tfThin);

        hideKeyboard(findViewById(R.id.relative_1));
        hideKeyboard(findViewById(R.id.relative_2));
        hideKeyboard(findViewById(R.id.interchange));

        ColorStateList csl = AppCompatResources.getColorStateList(this, R.color.app_blue);
        Drawable drawableone = getResources().getDrawable(R.drawable.ic_keyboard_arrow_down);
        DrawableCompat.setTintList(drawableone, csl);
        arrowDown.setImageDrawable(drawableone);
    }


    public void currencyApi(Activity activity) {
        Data.getCurrency(activity, new Data.UpdateCallback() {
            @Override
            public void onUpdate() {
                Log.d("tagg", "success api");
            }

            @Override
            public void onFailure() {
                Log.d("tagg", "fail api");
            }
        });
    }

    private String getCurrentDate() {
        calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = mdformat.format(calendar.getTime());
        String date = strDate.substring(0, 2);
        return date;
    }

    private String getCurrentMonth() {
        DateFormat dateFormat = new SimpleDateFormat("MM");
        Date date = new Date();
        String month = (dateFormat.format(date));
        String currMonth = null;
        if (month.equals("01")) {
            currMonth = "January";
        } else if (month.equals("02")) {
            currMonth = "February";
        } else if (month.equals("03")) {
            currMonth = "March";
        } else if (month.equals("04")) {
            currMonth = "April";
        } else if (month.equals("05")) {
            currMonth = "May";
        } else if (month.equals("06")) {
            currMonth = "June";
        } else if (month.equals("07")) {
            currMonth = "July";
        } else if (month.equals("08")) {
            currMonth = "August";
        } else if (month.equals("09")) {
            currMonth = "September";
        } else if (month.equals("10")) {
            currMonth = "October";
        } else if (month.equals("11")) {
            currMonth = "November";
        } else if (month.equals("12")) {
            currMonth = "December";
        }
        return currMonth;
    }

    private String getCurrentYear() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("yyyy/MM/dd");
        String strDate = mdformat.format(calendar.getTime());
        String year = strDate.substring(0, 4);
        return year;
    }

    private void hideKeyboard(View root) {
        root.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    View view = v.getRootView().findFocus();
                    if (view != null) {
                        InputMethodManager imm = (InputMethodManager) MainActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    }
                    return false;
                }
                return false;
            }
        });
    }



    @Override
    public void onBackPressed() {
        if (behavior.isHideable()) {
            super.onBackPressed();

        }else {
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }


    }



}
