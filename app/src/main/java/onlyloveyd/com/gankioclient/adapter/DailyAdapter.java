package onlyloveyd.com.gankioclient.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import onlyloveyd.com.gankioclient.R;
import onlyloveyd.com.gankioclient.gsonbean.DailyBean;
import onlyloveyd.com.gankioclient.utils.PublicTools;

/**
 * Created by lisa on 2016/12/19.
 * Email: 457420045@qq.com
 */

public class DailyAdapter extends GankAdapter {
    public DailyBean dailyData = null;
    public List<DailyBean.ResultsBean.DetailsBean> dailyDetails = new ArrayList<>();

    @Override
    public DailyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_daily, parent, false);
        return (new DailyViewHolder(view));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        System.err.println("yidong -- position = " + position + "dailyData = " + dailyData);
        if (dailyData != null && holder instanceof DailyViewHolder) {
            DailyViewHolder dailyViewHolder = (DailyViewHolder) holder;
            DailyBean.ResultsBean.DetailsBean detailsBean = dailyDetails.get(position);

            dailyViewHolder.tvTitleDaily.setText(detailsBean.getDesc().trim());
            dailyViewHolder.tvDateDaily.setText(PublicTools.date2String(detailsBean.getPublishedAt().getTime(), "yyyy.MM.dd"));

            if(detailsBean.getImages()!= null && detailsBean.getImages().size()>0) {
                Glide.with(mContext).load(detailsBean.getImages().get(0)).into(dailyViewHolder.ivDaily);
            } else {
                dailyViewHolder.ivDaily.setVisibility(View.INVISIBLE);
            }
            dailyViewHolder.tvTypeDaily.setText(detailsBean.getType());
        }
    }

    @Override
    public int getItemCount() {
        int count = 0;
        if (dailyData != null && dailyDetails.size()!= 0) {
            return dailyDetails.size();
        }
        return count;
    }

    public void setGankData(DailyBean dailyBean) {
        //System.err.println("yidong -- dailyBean = " + dailyBean);
        this.dailyData = dailyBean;

        if(dailyBean.getResults().getAndroid()!= null) {
            dailyDetails.addAll(dailyBean.getResults().getAndroid());
        }
        if(dailyBean.getResults().getApp()!= null) {
            dailyDetails.addAll(dailyBean.getResults().getApp());
        }
        if(dailyBean.getResults().getBonus()!= null) {
            dailyDetails.addAll(dailyBean.getResults().getBonus());
        }
        if(dailyBean.getResults().getIOS()!= null) {
            dailyDetails.addAll(dailyBean.getResults().getIOS());
        }
        if(dailyBean.getResults().getJs()!= null) {
            dailyDetails.addAll(dailyBean.getResults().getJs());
        }
        if(dailyBean.getResults().getRec()!= null) {
            dailyDetails.addAll(dailyBean.getResults().getRec());
        }
        if(dailyBean.getResults().getRes()!= null) {
            dailyDetails.addAll(dailyBean.getResults().getRes());
        }
        if(dailyBean.getResults().getVideo()!= null) {
            dailyDetails.addAll(dailyBean.getResults().getVideo());
        }


    }

    /**
     * bonus单纯图片
     */
    class DailyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_daily)
        ImageView ivDaily;
        @BindView(R.id.tv__type_daily)
        TextView tvTypeDaily;
        @BindView(R.id.tv_title_daily)
        TextView tvTitleDaily;
        @BindView(R.id.tv_date_daily)
        TextView tvDateDaily;

        public DailyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
