
package com.example.todoapispring;


@SuppressWarnings("unused")
public class Todo {


    public  Boolean mCompleted;

    public Long mId;

    public String mTitle;

    public Long mUserId;

    public Todo(boolean mCompleted, long mId, String mTitle, long mUserId){
        this.mCompleted = mCompleted;
        this.mId = mId;
        this.mTitle = mTitle;
        this.mUserId = mUserId;

    }

    public Boolean getCompleted() {
        return mCompleted;
    }

    public void setCompleted(Boolean completed) {
        mCompleted = completed;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Long getUserId() {
        return mUserId;
    }

    public void setUserId(Long userId) {
        mUserId = userId;
    }

    @Override
    public String toString(){
        return
                "Todo{"+
                        "mId = '" + mId + '\''+
                        ",mCompleted = '" +mCompleted +'\''+
                        ",mTitle =  '" +mTitle + '\''+
                        ",mUserId = '" +mUserId +'\''+
                        "}";
    }
}
