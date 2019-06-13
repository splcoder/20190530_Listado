package com.example.a2019_05_30_listado.helpers;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a2019_05_30_listado.R;

/**
 * A Yes/No confirm Dialog
 * Uses:
 ***************************************************************************************************
 * 		- in strings.xml:
 * 			<string name="dialog_confirm_title">Are you sure ?</string>
 * 			<string name="dialog_confirm_yes">Yes</string>
 * 			<string name="dialog_confirm_no">No</string>
 ***************************************************************************************************
 * 		- in styles.xml:
 * 	<style name="GradientButtonText">
 * 		<item name="android:layout_width">fill_parent</item>
 * 		<item name="android:layout_height">wrap_content</item>
 * 		<item name="android:textColor">#ffffff</item>
 * 		<item name="android:gravity">center</item>
 * 		<item name="android:layout_margin">3dp</item>
 * 		<item name="android:textAllCaps">false</item>
 * 		<item name="android:textSize">24dp</item>
 * 		<item name="android:textStyle">bold|italic</item>
 * 		<item name="android:shadowColor">#000000</item>
 * 		<item name="android:shadowDx">1</item>
 * 		<item name="android:shadowDy">1</item>
 * 		<item name="android:shadowRadius">2</item>
 * 	</style>
 ***************************************************************************************************
 * 		- layout -> dialog_confirm.xml:
 *
 * <?xml version="1.0" encoding="utf-8"?>
 * <LinearLayout
 * 	xmlns:android="http://schemas.android.com/apk/res/android"
 * 	android:orientation="vertical"
 * 	android:layout_width="match_parent"
 * 	android:layout_height="wrap_content">
 *
 * 	<TextView
 * 		android:id="@+id/idTvTitle"
 * 		android:layout_width="match_parent"
 * 		android:layout_height="wrap_content"
 * 		android:background="@drawable/gradient_button_red"
 * 		android:paddingLeft="10dp"
 * 		android:paddingTop="5dp"
 * 		android:paddingRight="10dp"
 * 		android:paddingBottom="5dp"
 * 		android:text="@string/dialog_confirm_title"
 * 		android:textAllCaps="false"
 * 		android:textColor="@color/white"
 * 		android:textSize="32sp"
 * 		android:textStyle="bold" />
 *
 * 	<LinearLayout
 * 		android:orientation="horizontal"
 * 		android:layout_width="match_parent"
 * 		android:layout_height="wrap_content">
 *
 * 		<Button
 * 			android:id="@+id/idBtnConfirmNo"
 * 			android:layout_width="wrap_content"
 * 			android:layout_height="wrap_content"
 * 			android:layout_marginLeft="10dp"
 * 			android:layout_marginTop="10dp"
 * 			android:layout_marginRight="5dp"
 * 			android:layout_marginBottom="10dp"
 * 			android:layout_weight="1"
 * 			android:background="@drawable/gradient_button_blue"
 * 			android:text="@string/dialog_confirm_no"
 * 			style="@style/GradientButtonText"/>
 *
 * 		<Button
 * 			android:id="@+id/idBtnConfirmYes"
 * 			android:layout_width="wrap_content"
 * 			android:layout_height="wrap_content"
 * 			android:layout_marginLeft="5dp"
 * 			android:layout_marginTop="10dp"
 * 			android:layout_marginRight="10dp"
 * 			android:layout_marginBottom="10dp"
 * 			android:layout_weight="1"
 * 			android:background="@drawable/gradient_button_blue"
 * 			android:text="@string/dialog_confirm_yes"
 * 			style="@style/GradientButtonText" />
 * 	</LinearLayout>
 * </LinearLayout>
 ***************************************************************************************************
 *
 * Example:
 * 		DialogConfirm dialogConfirm = new DialogConfirm( AnActivity.this );
 * 		dialogConfirm.setOnButtonClicked( new DialogConfirm.OnButtonClicked(){
 *          @Override
 * 			public void exe( boolean confirmed ) {
 * 				Toast.makeText( AnActivity.this, "DialogConfirm: " + (confirmed ? 1 : 0), Toast.LENGTH_LONG ).show();
 * 			}
 * 		});
 * 		dialogConfirm.show();
 ***************************************************************************************************
 */
public class DialogConfirm extends Dialog {
	private Context context;
	private Dialog dialog;
	private Button btnYes, btnNo;
	private boolean bState = false;
	TextView tvTitle;
	TextView tvText = null;
	LinearLayout llText;
	//---
	public interface OnButtonClicked {
		/**
		 * Executed when a button is clicked
		 * @param confirmed		true if "Yes" was clicked, false if "No"
		 */
		void exe(boolean confirmed);
	}
	private OnButtonClicked onButtonClicked = null;

	public DialogConfirm( Context context, boolean removeTvText ){
		super( context );
		this.context = context;
		dialog = new Dialog( context );
		dialog.requestWindowFeature( Window.FEATURE_NO_TITLE );
		dialog.setContentView( R.layout.dialog_confirm );
		btnYes = (Button)dialog.findViewById( R.id.idBtnConfirmYes );
		btnYes.setOnClickListener( new View.OnClickListener(){
			@Override
			public void onClick( View v ){
				dialog.dismiss();
				bState = true;
				if( onButtonClicked != null )
					onButtonClicked.exe( bState );
			}
		});
		btnNo = (Button)dialog.findViewById( R.id.idBtnConfirmNo );
		btnNo.setOnClickListener( new View.OnClickListener(){
			@Override
			public void onClick( View v ){
				dialog.dismiss();
				bState = false;
				if( onButtonClicked != null )
					onButtonClicked.exe( bState );
			}
		});
		//
		tvTitle = (TextView)dialog.findViewById( R.id.idTvTitle );
		tvText = (TextView)dialog.findViewById( R.id.idTvText );
		llText = (LinearLayout)dialog.findViewById( R.id.idLlText );
		if( removeTvText )	llText.removeAllViews();
	}
	public DialogConfirm( Context context ){
		this( context, true );
	}
	public DialogConfirm( Context context, String title ){
		this( context );
		tvTitle.setText( title );
	}
	public DialogConfirm( Context context, String title, String text ){
		this( context, false );
		tvTitle.setText( title );
		tvText.setText( text );
	}
	public DialogConfirm( Context context, String title, String text, String yes, String no ){
		this( context, title, text );
		btnYes.setText( yes );
		btnNo.setText( no );
	}
	public void setOnButtonClicked( OnButtonClicked obc ){
		this.onButtonClicked = obc;
	}
	public void show(){
		dialog.show();
	}
}
