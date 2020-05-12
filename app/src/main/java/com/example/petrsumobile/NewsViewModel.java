package com.example.petrsumobile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class NewsViewModel extends ViewModel {

    private MutableLiveData<ArrayList<News>> news;
    //private final MutableLiveData<News> selectedNewsItem = new MutableLiveData<News>();
    private News selectedNewsItem;
    private ArrayList<News> newsList = new ArrayList<News>();

    public void selectNews(News itemNews) {
        //Maybe take an index?
        //selectedNewsItem.setValue(itemNews);
        selectedNewsItem = itemNews;
    }

    /*public LiveData<News> getSelectedNews() {
        return selectedNewsItem;
    }*/

    public News getSelectedNews(){
        return selectedNewsItem;
    }

    public ArrayList<News> getNewsList(){
        return newsList;
    }

   /* public LiveData<ArrayList<News>> getNews() {
        if (news == null) {
            news = new MutableLiveData<ArrayList<News>>();
            loadNews();
        }
        return news;
    }*/


    /*private void loadNews() {
        // Do an asynchronous operation to fetch news.
        //TODO: make parse function
        newsList = DataQuery.fetchNewsData();
        news.setValue(newsList);

    }*/

   /* private void fetchNewsItems(){
        newsList.add(new News(
                "titletitletitletitletitletitletitletitle",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed imperdiet lobortis nisi, non iaculis urna rhoncus consectetur. Proin pretium molestie ligula eget condimentum. Proin varius, urna eget elementum elementum, risus lectus egestas diam, id eleifend risus lorem id sapien. Phasellus nec tortor nisi. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Etiam egestas a tortor ultricies fermentum. Sed aliquam nulla et mauris faucibus, ut fermentum libero ultricies. Duis ut magna sollicitudin, dictum nisl non, lacinia ante. Mauris vitae turpis mauris. Nulla facilisi. Fusce sit amet nibh vel dui mattis pulvinar et et mauris.\n" +
                        "\n" +
                        "Sed erat neque, fringilla in dapibus non, maximus a massa. Etiam purus justo, pellentesque id pharetra id, suscipit facilisis metus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Phasellus fermentum mi ut tincidunt tincidunt. Sed tempor orci ut maximus ultricies. Suspendisse scelerisque magna ut ipsum facilisis, et rutrum nulla mattis. Cras eget odio quis ante consequat ultrices quis blandit leo. Quisque sit amet tristique lorem, ut sagittis velit. Nunc interdum leo et sagittis lacinia. Nullam at sem sem. Aliquam nec risus ut nisi cursus semper. Curabitur lacus tellus, laoreet in ante eget, efficitur imperdiet ante.\n" +
                        "\n" +
                        "Pellentesque ut dapibus enim, sit amet porta odio. Sed ornare sit amet risus a convallis. Morbi a arcu lacinia arcu tincidunt fringilla. Sed in purus consectetur, venenatis urna ultricies, bibendum diam. Aenean id finibus leo. Proin blandit risus eu nisl fermentum, eu molestie orci semper. Duis imperdiet arcu id dapibus aliquam. Curabitur sed nibh vel nisl volutpat lobortis.\n" +
                        "\n" +
                        "Vestibulum ac neque quis justo efficitur volutpat. Etiam non urna eget sapien congue iaculis. Nulla eu aliquam dui. Fusce et neque non augue finibus suscipit. Sed auctor pulvinar sodales. Nam sed metus sapien. Duis rhoncus turpis at diam lobortis scelerisque. Curabitur nec ex sit amet libero suscipit ultricies vitae ut diam. Ut ac nisl nec diam maximus bibendum vel et libero. Maecenas ultricies, ante non tempus malesuada, mauris nibh tempor nibh, a rhoncus risus massa a augue. Morbi rhoncus a enim sit amet faucibus. In sit amet rutrum nisl, vel facilisis diam. Suspendisse ut ultricies turpis, a auctor velit. Ut vel libero ipsum.\n" +
                        "\n" +
                        "Mauris augue ex, bibendum a bibendum vel, bibendum in tortor. Curabitur eget urna finibus, posuere sapien sit amet, congue sem. Curabitur quis nisl sed libero viverra iaculis sed et risus. Nulla vel maximus libero. Nunc a finibus nulla. Proin in blandit elit, quis mollis ligula. Etiam egestas, ligula ac pellentesque fringilla, orci justo malesuada metus, eu mollis nunc ligula vel est. Suspendisse et bibendum ex. Suspendisse tristique placerat facilisis. Suspendisse sit amet eros ac neque dignissim fermentum. Nunc faucibus eu nisi a ultricies. Fusce congue metus quis fermentum posuere. Etiam quis ex id mi pharetra commodo.",
                "www.ya.ru",
                "28.04.2020",
                "image"));
        newsList.add(new News(
                "BIG TITLE GOOD NEWS",
                "description about description",
                "www.ya.ru",
                "27.04.2020",
                "image"));
        newsList.add(new News(
                "1BIG TITLE GOOD NEWS",
                "description about description",
                "www.ya.ru",
                "27.04.2020",
                "image"));
        newsList.add(new News(
                "2BIG TITLE GOOD NEWS",
                "description about description",
                "www.ya.ru",
                "27.04.2020",
                "image"));
        newsList.add(new News(
                "3BIG TITLE GOOD NEWS",
                "description about description",
                "www.ya.ru",
                "27.04.2020",
                "image"));
    }*/
}
