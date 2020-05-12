package com.example.petrsumobile;

import android.util.Log;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

public class DataQuery {

    private static final String LOG_TAG = DataQuery.class.getSimpleName();

    public static ArrayList<News> fetchNewsData() {

        String RSS_NEWS_URL = "https://petrsu.ru/rss";
        ArrayList<News> newsArrayList = new ArrayList<News>();

//        News rssItemT = new News("MSUG news", "Best IT news.",
//                new Date(), "http://msug.vn.ua/", "");
//
//        newsArrayList.add(rssItemT);

        try {
            URL url = new URL(RSS_NEWS_URL);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = httpURLConnection.getInputStream();

                //DocumentBuilderFactory, DocumentBuilder are used for
                //xml parsing
                DocumentBuilderFactory dbf = DocumentBuilderFactory
                        .newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();

                //using db (Document Builder) parse xml data and assign
                //it to Element
                Document document = db.parse(inputStream);
                Element element = document.getDocumentElement();

                //take rss nodes to NodeList
                NodeList nodeList = element.getElementsByTagName("item");

                if (nodeList.getLength() > 0) {
                    for (int i = 0; i < nodeList.getLength(); i++) {

                        //take each entry (corresponds to <item></item> tags in
                        //xml data

                        Element entry = (Element) nodeList.item(i);

                        Element _titleE = (Element) entry.getElementsByTagName(
                                "title").item(0);
                        Element _descriptionE = (Element) entry
                                .getElementsByTagName("description").item(0);
                        Element _pubDateE = (Element) entry
                                .getElementsByTagName("pubDate").item(0);
                        Element _linkE = (Element) entry.getElementsByTagName(
                                "link").item(0);
                        Element _imageURL = (Element) entry.getElementsByTagName(
                                "enclosure").item(0);

                        String _title = _titleE.getFirstChild().getNodeValue();
                        String _description = _descriptionE.getFirstChild().getNodeValue();
                        Date _pubDate = new Date(_pubDateE.getFirstChild().getNodeValue());
                        String _link = _linkE.getFirstChild().getNodeValue();
                        String _imageULR = _imageURL.getAttribute("url");
                        //String _imageULR = "";

                        //create RssItemObject and add it to the ArrayList
                        News news = new News(_title, _description,
                                _pubDate, _link, _imageULR);

                        newsArrayList.add(news);

//                        Log.d("newsList",newsArrayList.get(i).getNewsImageURL());
                    }
                }

            }
        } catch (Exception e) {
            //e.printStackTrace();
            Log.e("NewsLoader", "Problem parsing the news RSS results", e);
        }

        return newsArrayList;
    }

}
