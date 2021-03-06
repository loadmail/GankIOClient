package onlyloveyd.com.gankioclient.viewholder;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

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
public abstract  class BaseViewHolder<T> extends RecyclerView.ViewHolder{
    SparseArray<View> mViews;
    View mItemView;

    public BaseViewHolder(View itemView) {
        super(itemView);
        mItemView = itemView;
        mViews = new SparseArray<>();
    }

    public View getView(int resId) {
        View view = mViews.get(resId);

        if(view== null) {
            view = mItemView.findViewById(resId);
            mViews.put(resId, view);
        }
        return view;
    }

    public abstract void bindViewData(T data);
}