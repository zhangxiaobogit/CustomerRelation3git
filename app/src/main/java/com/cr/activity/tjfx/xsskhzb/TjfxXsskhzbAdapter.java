package com.cr.activity.tjfx.xsskhzb;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cr.tools.FigureTools;
import com.crcxj.activity.R;

public class TjfxXsskhzbAdapter extends BaseAdapter {

    List<Map<String, Object>> list;
    private Activity          activity;
    private int               selectIndex;

    public TjfxXsskhzbAdapter(List<Map<String, Object>> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public int getSelectIndex() {
        return selectIndex;
    }

    public void setSelectIndex(int selectIndex) {
        this.selectIndex = selectIndex;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        Map<String, Object> objMap = list.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(activity).inflate(R.layout.activity_tjfx_khdjtj_item,
                null);// 这个过程相当耗时间
            viewHolder = new ViewHolder();
            viewHolder.nameTextView = (TextView) convertView.findViewById(R.id.name_textview);
            viewHolder.valueTextView = (TextView) convertView.findViewById(R.id.value_textview);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.nameTextView.setText(objMap.get("depname").toString()+"  "+objMap.get("empname").toString());
        viewHolder.valueTextView.setText("￥"+ FigureTools.sswrFigure(objMap.get("saleamt").toString()));
        return convertView;
    }

    static class ViewHolder {
        TextView nameTextView;
        TextView valueTextView;
    }
}