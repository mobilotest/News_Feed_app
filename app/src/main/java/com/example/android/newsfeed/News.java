package com.example.android.newsfeed;

/**
 * An {@link News} object contains information related to a single earthquake.
 */
public class News {

    /** Thumbnail of the news item */
    private String mThumbnail;;

    /** Header of the news item */
    private String mNewsHeader;

    /** Body of the news item */
    private String mNewsBody;

    /** Section of the news item */
    private String mSection;

    /** Time of the news item */
    private long mTimeInMilliseconds;

    /** Website URL of the news item */
    private String mUrl;

    /**
     * Constructs a new {@link News} object.
     *
     * @param thumbnail is the image of the news
     * @param header is the header of the news
     * @param body is the body of the news
     * @param section is the section of the news
     * @param time is the time in milliseconds (from the Epoch) when the news published
     * @param url is the website URL to find more details about the news
     */

    public News(String thumbnail, String header, String body, String section, long time, String url) {
        mThumbnail = thumbnail;
        mSection = section;
        mNewsHeader = header;
        mNewsBody = body;
        mTimeInMilliseconds = time;
        mUrl = url;
    }

    /**
     * Get the thumbnail URL of the news item
     */
    public String getThumbnail() { return mThumbnail; }

    /**
     * Returns the section of the news item.
     */
    public String getSection() {
        return mSection;
    }

    /**
     * Returns the header of the news item.
     */
    public String getNewsHeader() {
        return mNewsHeader;
    }

    /**
     * Returns the body of the news item.
     */
    public String getNewsBody() {
        return mNewsBody;
    }

    /**
     * Returns the time of the news item.
     */
    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    /**
     * Returns the website URL to find more information about the news item.
     */
    public String getUrl() {
        return mUrl;
    }
}