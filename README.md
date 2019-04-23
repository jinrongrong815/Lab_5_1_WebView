# Lab_5_1_WebView
# 实验五：Intent

一、实验内容

1、通过自定义的WebView加载URL来验证隐式Intent的使用

输入URL网址，点击按钮，将发起浏览网页的行为，跳转之后，出现选择项，选择自定义的MyBrowser进行浏览

<image width=700 height=500 src="https://github.com/jinrongrong815/img_folder/blob/master/Lab_5_1q.png">
  
二、关键代码

1、

***MainActivity.java***

public class MainActivity extends AppCompatActivity {
    
    private Button button;
    private EditText edit_url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.bu_load_web);
        edit_url = (EditText) findViewById(R.id.edit_url);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                passData();
            }
        });
    }

    public void passData(){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(edit_url.getText().toString()));
        Intent choose = Intent.createChooser(intent,"选择一个浏览器");
        startActivity(choose);
    }

}

***WebViewLoadWeb.java***

public class WebViewLoadWeb extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
        webView = (WebView)findViewById(R.id.wv_webview);
        Intent intent = getIntent();
        String url = intent.getData().toString();
        loadWeb(url);
    }
    public void loadWeb(String url){
        //String url = "https://www.baidu.com/";
        //此方法可以在webview中打开链接而不会跳转到外部浏览器
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //重写onKeyDown，当浏览网页，WebView可以后退时执行后退操作。
        if(keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()){
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}

三、实验结果截图

<image width=350 height=550 src="https://github.com/jinrongrong815/img_folder/blob/master/Lab_5_1_anew1.png">
  
<image width=350 height=550 src="https://github.com/jinrongrong815/img_folder/blob/master/Lab_5_1anew2.png">
