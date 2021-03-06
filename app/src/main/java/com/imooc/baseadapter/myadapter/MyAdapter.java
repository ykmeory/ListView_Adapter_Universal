package com.imooc.baseadapter.myadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.imooc.baseadapter.R;
import com.imooc.baseadapter.bean.Bean;
import com.imooc.baseadapter.lvadapter.BaseLvHolder;

import java.util.List;

/**
 * 在BaseAdapter中使用BaseLvHolder可实现一种通用的Adapter
 * <p>
 * 注意：使用MyAdapter作为适配器时，会有CheckBox错乱的问题，可运行查看
 *
 * @author Administrator
 */
public class MyAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<Bean> mDatas;
    private Context mContext;
    private int mLayoutId;

    public MyAdapter(Context context, List<Bean> datas, int layoutId) {
        mContext = context;
        mDatas = datas;
        mLayoutId = layoutId;
        mInflater = LayoutInflater.from(context);
    }

    /**
     * @see android.widget.Adapter#getCount()
     */
    @Override
    public int getCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    /**
     * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseLvHolder holder = BaseLvHolder.get(mContext, convertView, parent, mLayoutId, position);
        Bean bean = mDatas.get(position);

        ((TextView) holder.getView(R.id.tv_title)).setText(bean.getTitle());
        ((TextView) holder.getView(R.id.tv_desc)).setText(bean.getDesc());
        ((TextView) holder.getView(R.id.tv_time)).setText(bean.getTime());
        ((TextView) holder.getView(R.id.tv_phone)).setText(bean.getPhone());

        //converView是在holder中的
        return holder.getConvertView();
    }


    /**
     * @see android.widget.Adapter#getItem(int)
     */
    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    /**
     * @see android.widget.Adapter#getItemId(int)
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

}
