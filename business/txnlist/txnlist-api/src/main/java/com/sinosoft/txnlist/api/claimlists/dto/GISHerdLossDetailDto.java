package com.sinosoft.txnlist.api.claimlists.dto;

/**
 * 理赔损失清单农户标的损失清单信息（养殖险耳标号清单）
 * @author 王心洋
 * @time 2018-01-18
 */
public class GISHerdLossDetailDto {
    private static final long serialVersionUID = 1L;
    String earLabel;//耳标号

    public String getEarLabel() {
        return earLabel;
    }

    public void setEarLabel(String earLabel) {
        this.earLabel = earLabel;
    }
}
