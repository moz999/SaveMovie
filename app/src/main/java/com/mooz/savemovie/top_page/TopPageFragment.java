package com.mooz.savemovie.top_page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mooz.savemovie.MainActivity;
import com.mooz.savemovie.R;

public class TopPageFragment extends Fragment {

    private static final String TOP_PAGE = "https://youtube.com";

    private Context mContext;
    private View mView;
    private WebView webView;

    /**
     * set fragment
     * @return this fragment
     */
    public static TopPageFragment newInstance(){
        TopPageFragment fragment = new TopPageFragment();
        Bundle bundle = fragment.getArguments();
        if(bundle == null){
            bundle = new Bundle();
        }
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        if(!(context instanceof MainActivity)){
            throw new UnsupportedOperationException("Listener is unsupported.");
        }else{
            mContext = context;
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        mView = inflater.inflate(R.layout.top_page_fragment, container, false);

        // Setting web view content.
        webView = mView.findViewById(R.id.top_page_webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(TOP_PAGE);

        return mView;
    }


}
