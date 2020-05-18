package com.example.petrsumobile;

import android.util.Log;
import com.example.petrsumobile.news.News;
import com.example.petrsumobile.schedule.Schedule;
import com.example.petrsumobile.schedule.ScheduleWeekday;
import com.example.petrsumobile.schedule.ScheduleWeekdayType;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class DataQuery {


    private static final String JSON_RESPONSE = "{\"denominator\":{\"Friday\":[{\"classroom\":\"337 ГК\",\"end_time\":" +
            "\"11:20\",\"lecturer\":\"Кулаков Кирилл Александрович\",\"name\":\"Технология производства программного " +
            "обеспечения\",\"number\":\"2\",\"start_time\":\"09:45\",\"type\":\"Лабораторные занятия 2/1\"}," +
            "{\"classroom\":\"306к УК-1\",\"end_time\":\"11:20\",\"lecturer\":\"Димитров Вячеслав Михайлович\"" +
            ",\"name\":\"Языки программирования и методы трансляции\",\"number\":\"2\",\"start_time\":\"09:45\"" +
            ",\"type\":\"Лабораторные занятия\"},{\"classroom\":\"352 ГК\",\"end_time\":\"13:05\",\"lecturer\":\"Кулаков" +
            " Кирилл Александрович\",\"name\":\"Web-технологии 2\",\"number\":\"3\",\"start_time\":\"11:30\",\"type\":\"" +
            "Практические занятия\"},{\"classroom\":\"250 ГК\",\"end_time\":\"15:05\",\"lecturer\":\"Пономарев Вадим " +
            "Анатольевич\",\"name\":\"Основы сетевого управления\",\"number\":\"4\",\"start_time\":\"13:30\",\"type\"" +
            ":\"Лекции\"},{\"classroom\":\"\",\"end_time\":\"15:05\",\"lecturer\":\"Ивашко Евгений Евгеньевич\",\"name\"" +
            ":\"Современные технологии высокопроизводительных вычислений\",\"number\":\"4\",\"start_time\":\"13:30\",\"" +
            "type\":\"Практические занятия\"},{\"classroom\":\"337 ГК\",\"end_time\":\"16:50\",\"lecturer\":\"Пономарев " +
            "Вадим Анатольевич\",\"name\":\"Основы сетевого управления\",\"number\":\"5\",\"start_time\":\"15:15\"," +
            "\"type\":\"Практические занятия 2\"}],\"Monday\":[{\"classroom\":\"352 ГК\",\"end_time\":\"13:05\"," +
            "\"lecturer\":\"Воронов Роман Владимирович\",\"name\":\"Криптографические средства защиты информации\"," +
            "\"number\":\"3\",\"start_time\":\"11:30\",\"type\":\"Лекции\"},{\"classroom\":\"356 ГК\",\"end_time\":" +
            "\"15:05\",\"lecturer\":\"Димитров Вячеслав Михайлович\",\"name\":\"Языки программирования и методы трансляции\"," +
            "\"number\":\"4\",\"start_time\":\"13:30\",\"type\":\"Лекции\"},{\"classroom\":\"356 ГК\",\"end_time\":\"16:50\"," +
            "\"lecturer\":\"Димитров Вячеслав Михайлович\",\"name\":\"Методы разработки ПО\",\"number\":\"5\",\"start_time\":" +
            "\"15:15\",\"type\":\"Лекции\"},{\"classroom\":\"239 ГК\",\"end_time\":\"20.15\",\"lecturer\":\"Крупко " +
            "Наталья Сергеевна\",\"name\":\"Программирование в системе 1С\",\"number\":\"6\",\"start_time\":\"18.00\"," +
            "\"type\":\"Лекции\"}],\"Saturday\":[{\"classroom\":\"\",\"end_time\":\"15:35\",\"lecturer\":\"Киселев " +
            "Александр Викторович\",\"name\":\"Физическая культура и спорт (элективная дисциплина, реализована за " +
            "рамками объема образовательной программы)\",\"number\":\"4\",\"start_time\":\"14:00\",\"type\":\"" +
            "Практические занятия\"}],\"Sunday\":[],\"Thursday\":[{\"classroom\":\"352 ГК\",\"end_time\":\"11:20\"" +
            ",\"lecturer\":\"Яковлева Дарья Сергеевна\",\"name\":\"Физика\",\"number\":\"2\",\"start_time\":\"09:45\"," +
            "\"type\":\"Лекции\"},{\"classroom\":\"244 ГК\",\"end_time\":\"13:05\",\"lecturer\":\"Яковлева Дарья " +
            "Сергеевна\",\"name\":\"Физика\",\"number\":\"3\",\"start_time\":\"11:30\",\"type\":\"Лабораторные " +
            "занятия 2\"},{\"classroom\":\"341 ГК\",\"end_time\":\"15:05\",\"lecturer\":\"Марахтанов Алексей " +
            "Георгиевич\",\"name\":\"Интернет-предпринимательство\",\"number\":\"4\",\"start_time\":\"13:30\"," +
            "\"type\":\"Лабораторные занятия\"},{\"classroom\":\"241 ГК\",\"end_time\":\"16:50\",\"lecturer\":" +
            "\"Кулаков Кирилл Александрович\",\"name\":\"Технология производства программного обеспечения\"," +
            "\"number\":\"5\",\"start_time\":\"15:15\",\"type\":\"Лабораторные занятия\"}],\"Tuesday\":[{\"classroom\":" +
            "\"306к УК-1\",\"end_time\":\"11:20\",\"lecturer\":\"Димитров Вячеслав Михайлович\",\"name\":\"Методы " +
            "разработки ПО\",\"number\":\"2\",\"start_time\":\"09:45\",\"type\":\"Лабораторные занятия\"},{\"classroom\"" +
            ":\"337 ГК\",\"end_time\":\"13:05\",\"lecturer\":\"Чистяков Дмитрий Борисович\",\"name\":\"Web-технологии 2\"" +
            ",\"number\":\"3\",\"start_time\":\"11:30\",\"type\":\"Лабораторные занятия\"},{\"classroom\":\"367 ГК\"" +
            ",\"end_time\":\"15:05\",\"lecturer\":\"Димитров Вячеслав Михайлович\",\"name\":\"Технология производства " +
            "программного обеспечения\",\"number\":\"4\",\"start_time\":\"13:30\",\"type\":\"Практические занятия\"}," +
            "{\"classroom\":\"355 ГК\",\"end_time\":\"16:50\",\"lecturer\":\"Марченков Сергей Александрович\",\"name\"" +
            ":\"Моделирование ПО\",\"number\":\"5\",\"start_time\":\"15:15\",\"type\":\"Практические занятия\"}]," +
            "\"Wednesday\":[{\"classroom\":\"367 ГК\",\"end_time\":\"11:20\",\"lecturer\":\"Блаткова Вера Валентиновна\"" +
            ",\"name\":\"Право\",\"number\":\"2\",\"start_time\":\"09:45\",\"type\":\"Практические занятия\"}," +
            "{\"classroom\":\"355 ГК\",\"end_time\":\"13:05\",\"lecturer\":\"Марахтанов Алексей Георгиевич\"," +
            "\"name\":\"Интернет-предпринимательство\",\"number\":\"3\",\"start_time\":\"11:30\",\"type\":" +
            "\"Лекции\"},{\"classroom\":\"\",\"end_time\":\"15:35\",\"lecturer\":\"Киселев Александр Викторович\"" +
            ",\"name\":\"Физическая культура и спорт (элективная дисциплина, реализована за рамками объема " +
            "образовательной программы)\",\"number\":\"4\",\"start_time\":\"14:00\",\"type\":\"Практические " +
            "занятия\"}]},\"numerator\":{\"Friday\":[{\"classroom\":\"337 ГК\",\"end_time\":\"11:20\"," +
            "\"lecturer\":\"Кулаков Кирилл Александрович\",\"name\":\"Технология производства программного обеспечения\"" +
            ",\"number\":\"2\",\"start_time\":\"09:45\",\"type\":\"Лабораторные занятия 2/1\"},{\"classroom\":" +
            "\"306к УК-1\",\"end_time\":\"11:20\",\"lecturer\":\"Димитров Вячеслав Михайлович\",\"name\":\"Язы" +
            "ки программирования и методы трансляции\",\"number\":\"2\",\"start_time\":\"09:45\",\"type\":\"Ла" +
            "бораторные занятия\"},{\"classroom\":\"352 ГК\",\"end_time\":\"13:05\",\"lecturer\":\"Кулаков Кир" +
            "илл Александрович\",\"name\":\"Web-технологии 2\",\"number\":\"3\",\"start_time\":\"11:30\",\"typ" +
            "e\":\"Лекции\"},{\"classroom\":\"\",\"end_time\":\"15:05\",\"lecturer\":\"Ивашко Евгений Евгеньев" +
            "ич\",\"name\":\"Современные технологии высокопроизводительных вычислений\",\"number\":\"4\",\"sta" +
            "rt_time\":\"13:30\",\"type\":\"Лекции\"}],\"Monday\":[{\"classroom\":\"352 ГК\",\"end_time\":\"13" +
            ":05\",\"lecturer\":\"Воронов Роман Владимирович\",\"name\":\"Криптографические средства защиты ин" +
            "формации\",\"number\":\"3\",\"start_time\":\"11:30\",\"type\":\"Лекции\"},{\"classroom\":\"239 ГК" +
            "\",\"end_time\":\"15:05\",\"lecturer\":\"Воронов Роман Владимирович\",\"name\":\"Криптографически" +
            "е средства защиты информации\",\"number\":\"4\",\"start_time\":\"13:30\",\"type\":\"Лабораторные " +
            "занятия\"},{\"classroom\":\"355 ГК\",\"end_time\":\"16:50\",\"lecturer\":\"Яковлева Дарья Сергеев" +
            "на\",\"name\":\"Физика\",\"number\":\"5\",\"start_time\":\"15:15\",\"type\":\"Практические заняти" +
            "я\"},{\"classroom\":\"239 ГК\",\"end_time\":\"20.15\",\"lecturer\":\"Крупко Наталья Сергеевна\",\"" +
            "name\":\"Программирование в системе 1С\",\"number\":\"6\",\"start_time\":\"18.00\",\"type\":\"Лек" +
            "ции\"}],\"Saturday\":[{\"classroom\":\"\",\"end_time\":\"15:35\",\"lecturer\":\"Киселев Александр" +
            " Викторович\",\"name\":\"Физическая культура и спорт (элективная дисциплина, реализована за рамка" +
            "ми объема образовательной программы)\",\"number\":\"4\",\"start_time\":\"14:00\",\"type\":\"Практ" +
            "ические занятия\"}],\"Sunday\":[],\"Thursday\":[{\"classroom\":\"352 ГК\",\"end_time\":\"11:20\"," +
            "\"lecturer\":\"Яковлева Дарья Сергеевна\",\"name\":\"Физика\",\"number\":\"2\",\"start_time\":\"0" +
            "9:45\",\"type\":\"Лекции\"},{\"classroom\":\"237 ГК\",\"end_time\":\"13:05\",\"lecturer\":\"Димит" +
            "ров Вячеслав Михайлович\",\"name\":\"Методы разработки ПО\",\"number\":\"3\",\"start_time\":\"11:" +
            "30\",\"type\":\"Практические занятия\"},{\"classroom\":\"241 ГК\",\"end_time\":\"16:50\",\"lectur" +
            "er\":\"Кулаков Кирилл Александрович\",\"name\":\"Технология производства программного обеспечения" +
            "\",\"number\":\"5\",\"start_time\":\"15:15\",\"type\":\"Лабораторные занятия\"}],\"Tuesday\":[{\"" +
            "classroom\":\"306к УК-1\",\"end_time\":\"11:20\",\"lecturer\":\"Димитров Вячеслав Михайлович\",\"" +
            "name\":\"Методы разработки ПО\",\"number\":\"2\",\"start_time\":\"09:45\",\"type\":\"Лабораторные" +
            " занятия\"},{\"classroom\":\"337 ГК\",\"end_time\":\"13:05\",\"lecturer\":\"Чистяков Дмитрий Бори" +
            "сович\",\"name\":\"Web-технологии 2\",\"number\":\"3\",\"start_time\":\"11:30\",\"type\":\"Лабора" +
            "торные занятия\"},{\"classroom\":\"367 ГК\",\"end_time\":\"15:05\",\"lecturer\":\"Димитров Вячесл" +
            "ав Михайлович\",\"name\":\"Технология производства программного обеспечения\",\"number\":\"4\",\"" +
            "start_time\":\"13:30\",\"type\":\"Практические занятия\"},{\"classroom\":\"355 ГК\",\"end_time\":" +
            "\"16:50\",\"lecturer\":\"Марченков Сергей Александрович\",\"name\":\"Моделирование ПО\",\"number\"" +
            ":\"5\",\"start_time\":\"15:15\",\"type\":\"Практические занятия\"}],\"Wednesday\":[{\"classroom\"" +
            ":\"352 ГК\",\"end_time\":\"09:35\",\"lecturer\":\"Корзун Дмитрий Жоржевич\",\"name\":\"Моделирова" +
            "ние ПО\",\"number\":\"1\",\"start_time\":\"08:00\",\"type\":\"Лекции\"},{\"classroom\":\"367 ГК\"" +
            ",\"end_time\":\"11:20\",\"lecturer\":\"Блаткова Вера Валентиновна\",\"name\":\"Право\",\"number\"" +
            ":\"2\",\"start_time\":\"09:45\",\"type\":\"Лекции\"},{\"classroom\":\"244 ГК\",\"end_time\":\"13:" +
            "05\",\"lecturer\":\"Яковлева Дарья Сергеевна\",\"name\":\"Физика\",\"number\":\"3\",\"start_time\"" +
            ":\"11:30\",\"type\":\"Лабораторные занятия 2\"},{\"classroom\":\"\",\"end_time\":\"15:35\",\"lect" +
            "urer\":\"Киселев Александр Викторович\",\"name\":\"Физическая культура и спорт (элективная дисцип" +
            "лина, реализована за рамками объема образовательной программы)\",\"number\":\"4\",\"start_time\":" +
            "\"14:00\",\"type\":\"Практические занятия\"}]}}";

    private static final String LOG_TAG = DataQuery.class.getSimpleName();

    public static ArrayList<News> fetchNewsData() {

        String RSS_NEWS_URL = "https://petrsu.ru/rss";
        ArrayList<News> newsArrayList = new ArrayList<News>();

        try {
            URL url = new URL(RSS_NEWS_URL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = httpURLConnection.getInputStream();

                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();

                Document document = db.parse(inputStream);
                Element element = document.getDocumentElement();

                NodeList nodeList = element.getElementsByTagName("item");

                if (nodeList.getLength() > 0) {
                    for (int i = 0; i < nodeList.getLength(); i++) {
                        Element entry = (Element) nodeList.item(i);

                        Element _titleE = (Element) entry.getElementsByTagName("title").item(0);
                        Element _descriptionE = (Element) entry.getElementsByTagName("description").item(0);
                        Element _pubDateE = (Element) entry.getElementsByTagName("pubDate").item(0);
                        Element _linkE = (Element) entry.getElementsByTagName("link").item(0);
                        Element _imageURL = (Element) entry.getElementsByTagName("enclosure").item(0);

                        String _title = _titleE.getFirstChild().getNodeValue();
                        String _description = _descriptionE.getFirstChild().getNodeValue();
                        Date _pubDate = new Date(_pubDateE.getFirstChild().getNodeValue());
                        String _link = _linkE.getFirstChild().getNodeValue();
                        String _imageULR = _imageURL.getAttribute("url");

                        News news = new News(_title, _description, _pubDate, _link, _imageULR);

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

    public static ArrayList<ScheduleWeekdayType> fetchScheduleData() {

        //String JSON_SCHEDULE_URL = "https://petrsu.ru/rss";
        ArrayList<ScheduleWeekdayType> scheduleWeekdayTypeArrayList = new ArrayList<ScheduleWeekdayType>();


        String[] weekdayName = new String[]{"Monday","Tuesday", "Wednesday", "Thursday", "Friday","Saturday", "Sunday"};
        String[] weekType = new String[]{"denominator","numerator"};

        try {
//            URL url = new URL(RSS_NEWS_URL);

            JSONObject baseJsonResponse = new JSONObject(JSON_RESPONSE);
           // JSONObject scheduleWeekdayObject = baseJsonResponse.getJSONObject("denominator");

            for (int z = 0; z < weekType.length; z++) {

                ArrayList<ScheduleWeekday> scheduleWeekdays = new ArrayList<ScheduleWeekday>();
                JSONObject scheduleWeekdayTypeJson = baseJsonResponse.getJSONObject(weekType[z]);

                for (int i = 0; i < weekdayName.length; i++) {

                    ArrayList<Schedule> scheduleArrayList = new ArrayList<Schedule>();
                    JSONArray day = scheduleWeekdayTypeJson.getJSONArray(weekdayName[i]);
                    for (int j = 0; j < day.length(); j++) {
                        JSONObject currentLesson = day.getJSONObject(j);

                        String classroom = currentLesson.getString("classroom");
                        String startTime = currentLesson.getString("start_time");
                        String endTime = currentLesson.getString("end_time");
                        String lecturer = currentLesson.getString("lecturer");
                        String name = currentLesson.getString("name");
                        String type = currentLesson.getString("type");
                        Integer number = currentLesson.getInt("number");

                        Schedule schedule = new Schedule(classroom, startTime, endTime, lecturer, name, type, number);
                        scheduleArrayList.add(schedule);

                        //Log.d(LOG_TAG,classroom);
                    }

                    ScheduleWeekday scheduleWeekday = new ScheduleWeekday(scheduleArrayList, weekdayName[i]);
                    scheduleWeekdays.add(scheduleWeekday);
                }
                ScheduleWeekdayType scheduleWeekdayType = new ScheduleWeekdayType(scheduleWeekdays,weekType[z]);
                scheduleWeekdayTypeArrayList.add(scheduleWeekdayType);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            Log.e("fetchScheduleData", "Problem parsing the schedule JSON results", e);
        }

        return scheduleWeekdayTypeArrayList;
    }


}
