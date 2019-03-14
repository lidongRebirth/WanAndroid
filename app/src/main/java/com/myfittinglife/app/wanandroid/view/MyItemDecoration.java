package com.myfittinglife.app.wanandroid.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 作者    LD
 * 时间    2018/11/16 15:32
 * 描述    设置RecyclerView各个item之间的间距
 */
public class MyItemDecoration extends RecyclerView.ItemDecoration {

    private final int verticalSpaceHeight;
    private final Drawable mDivider;


    public MyItemDecoration(int verticalSpaceHeight) {
        this.verticalSpaceHeight = verticalSpaceHeight;
        mDivider = new ColorDrawable(Color.RED);

    }

    /**
     * 如果你想设置左右空隙，和上部空隙，增加outRect.top, outRect.left 和 outRect.right这几个属性就好。
     * 如果你不想给最后一个条目加上间距，加上如下：
     * if (parent.getChildAdapterPosition(view) != parent.getAdapter().getItemCount() - 1) {
            outRect.bottom = verticalSpaceHeight;
        }
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (parent.getChildAdapterPosition(view) != parent.getAdapter().getItemCount() - 1) {   //判断是否是最后一个，最后一个item不加线
            outRect.bottom = verticalSpaceHeight;
        }
    }
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {

        mDivider.draw(c);
        super.onDraw(c, parent, state);
    }
}
