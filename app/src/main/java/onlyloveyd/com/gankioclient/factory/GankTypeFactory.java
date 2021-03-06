package onlyloveyd.com.gankioclient.factory;

import android.view.View;

import onlyloveyd.com.gankioclient.R;
import onlyloveyd.com.gankioclient.gsonbean.DailyBean;
import onlyloveyd.com.gankioclient.gsonbean.DataBean;
import onlyloveyd.com.gankioclient.gsonbean.ResultsBean;
import onlyloveyd.com.gankioclient.gsonbean.SearchBean;
import onlyloveyd.com.gankioclient.viewholder.BaseViewHolder;
import onlyloveyd.com.gankioclient.viewholder.BonusViewHolder;
import onlyloveyd.com.gankioclient.viewholder.DailyViewHolder;
import onlyloveyd.com.gankioclient.viewholder.DataViewHolder;

/**
 * Copyright 2017 yidong
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class GankTypeFactory implements TypeFactory {

    public static final int DAILY_ITEM_LAYOUT = R.layout.rv_item_daily;
    public static final int DATA_ITEM_LAYOUT = R.layout.rv_item_text;
    public static final int BONUS_ITEM_LAYOUT = R.layout.rv_item_image;

    @Override
    public int type(DailyBean.ResultsBean.DetailsBean dailyBean) {
        return DAILY_ITEM_LAYOUT;
    }

    @Override
    public int type(ResultsBean contentBean) {
        if(contentBean.getType().equals("福利")) {
            return BONUS_ITEM_LAYOUT;
        } else {
            return DATA_ITEM_LAYOUT;
        }
    }

    @Override
    public BaseViewHolder createViewHolder(int type, View itemView) {
        switch (type) {
            case DAILY_ITEM_LAYOUT:
                return new DailyViewHolder(itemView);
            case DATA_ITEM_LAYOUT:
                return new DataViewHolder(itemView);
            case BONUS_ITEM_LAYOUT:
                return new BonusViewHolder(itemView);
            default:
                return null;
        }
    }
}
