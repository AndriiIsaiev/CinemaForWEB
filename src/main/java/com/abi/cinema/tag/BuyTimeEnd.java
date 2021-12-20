package com.abi.cinema.tag;

import com.abi.cinema.db.dao.ReservePool;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.sql.Timestamp;

public class BuyTimeEnd extends TagSupport {
    private Timestamp buyTime;

    public void setBuyTime(Timestamp buyTime) {
        this.buyTime = buyTime;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().println(new Timestamp(buyTime.getTime() + ReservePool.TICKET_RESERVATION_TIME));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

}
