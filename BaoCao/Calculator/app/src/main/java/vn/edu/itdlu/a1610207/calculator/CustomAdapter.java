package vn.edu.itdlu.a1610207.calculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import vn.edu.itdlu.a1610207.calculator.Database.Calculation;

public class CustomAdapter extends BaseAdapter {
	private static LayoutInflater inflater = null;
	Context context;
	List<Calculation> list;
	
	public CustomAdapter(Context context, List<Calculation> list) {
		this.context = context;
		this.list = list;
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
	public long getItemId(int postion) {
		return postion;
	}
	
	@Override
	public View getView(int positon, View convertView, ViewGroup parent) {
		View view = convertView;
		if (view == null)
			view = inflater.inflate(R.layout.list_item, null);
		TextView exp = (TextView) view.findViewById(R.id.tv_item_exp);
		TextView result = (TextView) view.findViewById(R.id.tv_item_result);
		exp.setText(list.get(positon).getExpression());
		result.setText(list.get(positon).getResult());
		return view;
	}
}
