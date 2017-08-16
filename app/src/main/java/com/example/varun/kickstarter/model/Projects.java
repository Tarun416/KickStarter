package com.example.varun.kickstarter.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by varun on 8/13/17.
 */

public class Projects
{
    @SerializedName("title")
    private String title;

    @SerializedName("num.backers")
    private String num_backers;

    private String end_time;

    private String location;

    @SerializedName("amt.pledged")
    private String amt_pledged;

    private String state;

    private String by;

    @SerializedName("percentage.funded")
    private String percentage_funded;

    private String blurb;

    private String type;

    private String url;

    private String currency;

    private String country;

    @SerializedName("s.no")
    private String s_no;

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getNumbackers ()
{
    return num_backers;
}

    public void setNumbackers (String num_backers)
{
    this.num_backers = num_backers;
}

    public String getEndtime ()
{
    return end_time;
}

    public void setEndtime (String end_time)
{
    this.end_time = end_time;
}

    public String getLocation ()
    {
        return location;
    }

    public void setLocation (String location)
    {
        this.location = location;
    }

    public String getAmtpledged ()
{
    return amt_pledged;
}

    public void setAmtpledged (String amtpledged)
{
    this.amt_pledged = amtpledged;
}

    public String getState ()
    {
        return state;
    }

    public void setState (String state)
    {
        this.state = state;
    }

    public String getBy ()
    {
        return by;
    }

    public void setBy (String by)
    {
        this.by = by;
    }

    public String getPercentagefunded ()
{
    return percentage_funded;
}

    public void setPercentagefunded (String percentage_funded)
{
    this.percentage_funded = percentage_funded;
}

    public String getBlurb ()
    {
        return blurb;
    }

    public void setBlurb (String blurb)
    {
        this.blurb = blurb;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public String getCurrency ()
    {
        return currency;
    }

    public void setCurrency (String currency)
    {
        this.currency = currency;
    }

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    public String getSno ()
{
    return s_no;
}

    public void setSno (String sno)
{
    this.s_no = sno;
}

    @Override
    public String toString()
    {
        return "ClassPojo [title = "+title+", num.backers = "+num_backers+", end.time = "+end_time+", location = "+location+", amt.pledged = "+amt_pledged+", state = "+state+", by = "+by+", percentage.funded = "+percentage_funded+", blurb = "+blurb+", type = "+type+", url = "+url+", currency = "+currency+", country = "+country+", s.no = "+s_no+"]";
    }
}
