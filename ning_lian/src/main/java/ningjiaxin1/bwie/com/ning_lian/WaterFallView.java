package ningjiaxin1.bwie.com.ning_lian;

import android.content.Context;
import android.graphics.Canvas;
import android.icu.util.Measure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class WaterFallView extends LinearLayout {

    int mMaxChildHeight;
    //定义孩子的左右间距
    int mChildLeft=20;
    //定义孩子的上下间距
    int mChildTop=20;
    Context mContext;
    public WaterFallView(Context context) {
        super(context);
        mContext=context;
    }

    public WaterFallView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    //定义一个精确的测量方法

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //得到父布局的高和宽
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHright = MeasureSpec.getSize(heightMeasureSpec);
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        findMaxChildMaxHeight();

        int left=0,top=0;
        int childCount = getChildCount();
        for(int i=0;i<childCount;i++){
            View view = getChildAt(i);
            if(left!=0){
                if((left+view.getMeasuredWidth())>sizeWidth){
                    top+=mMaxChildHeight+mChildTop;
                    left=0;
                }
            }
            left+=view.getMeasuredWidth()+mChildLeft;
        }
        setMeasuredDimension(sizeWidth,(top+mMaxChildHeight)>sizeHright?sizeHright:top+mMaxChildHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        findMaxChildMaxHeight();
        int left=0,top=0;
        int childCount = getChildCount();
        for(int i=0;i<childCount;i++){
            View view = getChildAt(i);
            if(left!=0){
                if((left+view.getMeasuredWidth())>getWidth()){
                    top+=mMaxChildHeight+mChildTop;
                    left=0;
                }
            }
            view.layout(left,top,left+view.getMeasuredWidth(),top+mMaxChildHeight);
            left +=mChildLeft+view.getMeasuredWidth();
        }
    }

    private void findMaxChildMaxHeight() {
     mMaxChildHeight=0;
        int childCount = getChildCount();
        for(int i=0;i<childCount;i++){
            View view = getChildAt(i);
            if(view.getMeasuredHeight()>mMaxChildHeight){
                mMaxChildHeight=view.getMeasuredHeight();
            }
        }
    }

}
