//package text.tao.com.myapplication.utils;
//
//import android.support.v4.view.ViewPager;
//import android.view.View;
//
//public abstract class ABaseTransformer implements ViewPager.PageTransformer {
//    protected static final float min(float paramFloat1, float paramFloat2) {
//        if (paramFloat1 < paramFloat2) {
//            return paramFloat2;
//        }
//        return paramFloat1;
//    }
//
//    public void transformPage(View paramView, float paramFloat) {
//        onPreTransform(paramView, paramFloat);
//        onTransform(paramView, paramFloat);
//        onPostTransform(paramView, paramFloat);
//    }
//
//    protected void onPreTransform(View paramView, float paramFloat) {
//        float f1 = paramView.getWidth();
//        paramView.setRotationX(0.0F);
//        paramView.setRotationY(0.0F);
//        paramView.setRotation(0.0F);
//        paramView.setScaleX(1.0F);
//        paramView.setScaleY(1.0F);
//        paramView.setPivotX(0.0F);
//        paramView.setPivotY(0.0F);
//        paramView.setTranslationY(0.0F);
//        float f2;
//        float f3;
//        if (isPagingEnabled()) {
//            f2 = 0.0F;
//            paramView.setTranslationX(f2);
//            if (!hideOffscreenPages()) {
//                break label118;
//            }
//            boolean bool1 = paramFloat < -1.0F;
//            f3 = 0.0F;
//            if (bool1) {
//                boolean bool2 = paramFloat < 1.0F;
//                f3 = 0.0F;
//                if (bool2) {
//                    break label112;
//                }
//            }
//        }
//        for (; ; ) {
//            paramView.setAlpha(f3);
//            return;
//            f2 = paramFloat * -f1;
//            break;
//            label112:
//            f3 = 1.0F;
//        }
//        label118:
//        paramView.setAlpha(1.0F);
//    }
//
//    protected abstract void onTransform(View paramView, float paramFloat);
//
//    protected void onPostTransform(View paramView, float paramFloat) {
//    }
//
//    protected boolean isPagingEnabled() {
//        return false;
//    }
//
//    protected boolean hideOffscreenPages() {
//        return true;
//    }
//}
//
//
///* Location:              /Users/bob/Downloads/mmm/dex2jar-0.0.9.15/classes_dex2jar.jar!/mvp/tao/com/utils/ABaseTransformer.class
// * Java compiler version: 6 (50.0)
// * JD-Core Version:       0.7.1
// */