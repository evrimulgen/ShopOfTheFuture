package com.wisemandesigns.shopofthefuture.ui;

import com.wisemandesigns.shopofthefuture.R;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class PointsFragment extends Fragment implements ViewSwitcher.ViewFactory {

	private TextSwitcher mSwitcher;	
	private int count = 0;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_points, container, false);
		return view;
	}
  
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
    
		mSwitcher = (TextSwitcher) this.getActivity().findViewById(R.id.textSwitcher1);
		mSwitcher.setFactory(this);

		Animation in = AnimationUtils.loadAnimation(getActivity(), R.anim.push_up_in);
		Animation out = AnimationUtils.loadAnimation(getActivity(), R.anim.push_up_out);
		mSwitcher.setInAnimation(in);
		mSwitcher.setOutAnimation(out);
		
		Button button = (Button) getActivity().findViewById(R.id.button1);
			   button.setOnClickListener(new OnClickListener()
			   {
			             @Override
			             public void onClick(View v)
			             {
			                setText("");
			             } 
			   }); 
    
  }
	
	

  public void setText(String item)
  {
	  count ++;
	  mSwitcher.setText(String.valueOf(count));
  }

  @Override
  public View makeView()
  {
		TextView myText = new TextView(getActivity());
        myText.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
        myText.setTextSize(250);
        myText.setTextColor(Color.BLUE);
        return myText;
  }
} 