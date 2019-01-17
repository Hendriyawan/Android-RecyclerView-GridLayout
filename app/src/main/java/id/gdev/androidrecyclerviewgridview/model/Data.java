package id.gdev.androidrecyclerviewgridview.model;

public class Data {
    private int resId;
    private String title;

    public Data(int resId, String title) {
        this.resId = resId;
        this.title = title;
    }

    public int getResId() {
        return resId;
    }

    public String getTitle() {
        return title;
    }
}
