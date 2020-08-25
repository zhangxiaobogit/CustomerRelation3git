package com.cr.activity.jxc.xsgl.xskd;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.cr.RequestAddress;
import com.cr.activity.jxc.JXC_HTTP_Util;
import com.cr.activity.jxc.SpxqCkActivity;
import com.cr.activity.jxc.cggl.cgdd.JxcCgglCgddShlcActivity;
import com.cr.activity.jxc.spxq.SpxqActivity;
import com.cr.activity.jxc.xsgl.xskd.bean.XsKdBean;
import com.cr.data.http.response.XskdBillMasterResponseData;
import com.cr.http.NetworkRequestDataUtils;
import com.cr.tools.FigureTools;
import com.cr.tools.PaseJson;
import com.cr.tools.ServerURL;
import com.cr.tools.ShareUserInfo;
import com.crcxj.activity.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.update.base.BaseActivity;
import com.update.base.BaseP;
import com.update.base.BaseRecycleAdapter;
import com.update.utils.LogUtils;
import com.update.viewbar.TitleBar;
import com.update.viewholder.ViewHolderFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/*
 * 销售开单主
 */
public class XskdXqActivity extends BaseActivity {
    @BindView(R.id.titlebar)
    TitleBar titlebar;
    @BindView(R.id.tv_djbh)
    TextView tvDjbh;
    @BindView(R.id.iv_shzt)
    ImageView ivShzt;
    @BindView(R.id.tv_ckck)
    TextView tvCkck;
    @BindView(R.id.tv_kh)
    TextView tvKh;
    @BindView(R.id.tv_lxr)
    TextView tvLxr;
    @BindView(R.id.et_lxdh)
    EditText etLxdh;
    @BindView(R.id.tv_fplx)
    TextView tvFplx;
    @BindView(R.id.tv_skrq)
    TextView tvSkrq;
    @BindView(R.id.tv_xm)
    TextView tvXm;
    @BindView(R.id.tv_xzspsl)
    TextView tvXzspsl;
    @BindView(R.id.et_khqk)
    EditText etKhqk;
    @BindView(R.id.et_hjje)
    EditText etHjje;
    @BindView(R.id.et_skje)
    EditText etSkje;
    @BindView(R.id.tv_sklx)
    TextView tvSklx;
    @BindView(R.id.tv_zjzh)
    TextView tvZjzh;
    @BindView(R.id.tv_wlgs)
    TextView tvWlgs;
    @BindView(R.id.tv_dszh)
    TextView tvDszh;
    @BindView(R.id.et_dsje)
    EditText etDsje;
    @BindView(R.id.et_skhj)
    EditText etSkhj;
    @BindView(R.id.tv_djrq)
    TextView tvDjrq;
    @BindView(R.id.tv_bm)
    TextView tvBm;
    @BindView(R.id.tv_ywy)
    TextView tvYwy;
    @BindView(R.id.tv_zdr)
    TextView tvZdr;
    @BindView(R.id.et_bzxx)
    EditText etBzxx;
    @BindView(R.id.et_jhdz)
    EditText etJhdz;
    @BindView(R.id.rcv_xskd)
    RecyclerView rcv_xskd;
    @BindView(R.id.bt_sh)
    Button bt_sh;

    @BindView(R.id.bd_sd)
    Button bd_sd;

    public int DELETC_DATA = 10001;
    private XskdBillMasterResponseData mMasterResponseData;
    private List<XsKdBean> mDetailResponseDataList;

    public static Intent getMyIntent(Context packageContext, String billid) {
        Intent intent = new Intent(packageContext, XskdXqActivity.class);
        intent.putExtra("billid", billid);
        return intent;
    }


    private String mBillid;

    private Map<String, Object> mRequest;

    /**
     * 初始化变量，包括Intent带的数据和Activity内的变量。
     */
    @Override
    protected void initVariables() {
        presenter = new BaseP(this, this);
        mBillid = getIntent().getStringExtra("billid");
        mRequest = NetworkRequestDataUtils.getBillMaster(mActivity, "XSKD", mBillid);
        mRequest.put("opid", ShareUserInfo.getUserId(mActivity));
        presenter.post(RequestAddress.BILLMASTER_CODE, RequestAddress.BILLMASTER, mRequest);
    }

    /**
     * 指定加载布局
     *
     * @return 返回布局
     */
    @Override
    protected int getLayout() {
        return R.layout.activity_xskd_xq;
    }

    /**
     * 初始化
     */
    String currentBillid;

    @Override
    protected void init() {
        currentBillid = getIntent().getExtras().getString("billid");
        titlebar.setTitleText(this, "销售开单");

    }

    @OnClick({R.id.bt_sh, R.id.bd_sd})
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.bt_sh:
                intent.putExtra("tb", "tb_invoice");
                intent.putExtra("opid", ShareUserInfo.getUserId(mActivity));
                intent.putExtra("billid", currentBillid);
                intent.setClass(this, JxcCgglCgddShlcActivity.class);
                startActivityForResult(intent, 9);
                break;
            case R.id.bd_sd:
                if (!ShareUserInfo.getKey(this, "sc").equals("1")) {
                    Toast.makeText(this, "你没有该权限，请向管理员申请权限！", Toast.LENGTH_SHORT).show();
                    return;
                }
                new AlertDialog.Builder(this)
                        .setTitle("确定要删除当前记录吗？")
                        .setNegativeButton("删除",
                                new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface arg0,
                                                        int arg1) {
                                        presenter.post(DELETC_DATA, ServerURL.BILLDELMASTER,
                                                (Map<String, Object>) JXC_HTTP_Util.Companion.getInstance().deleteData(
                                                        ShareUserInfo.getDbName(mActivity),
                                                        "tb_invoice", currentBillid,
                                                        ShareUserInfo.getUserId(mActivity)));
                                    }
                                }).setPositiveButton("取消", null).show();
                break;

        }
    }

    /**
     * 网路请求返回数据
     *
     * @param requestCode 请求码
     * @param data        数据
     */
    @Override
    public void returnData(int requestCode, Object data) {
        super.returnData(requestCode, data);
        switch (requestCode) {
            case RequestAddress.BILLMASTER_CODE:
                LogUtils.d(data.toString());
                mMasterResponseData = JSON.parseArray(data.toString(), XskdBillMasterResponseData.class).get(0);
                presenter.post(RequestAddress.BILLDETAIL_CODE, RequestAddress.BILLDETAIL, mRequest);
                setMasterData();
                break;
            case RequestAddress.BILLDETAIL_CODE:
                LogUtils.d(data.toString());
                mDetailResponseDataList = new Gson().fromJson(data.toString(), new TypeToken<List<XsKdBean>>() {
                }.getType());
                LogUtils.e(JSON.toJSONString(mDetailResponseDataList));
                /* 选择商品集合信息处理 */
                rcv_xskd.setLayoutManager(new LinearLayoutManager(this));
                rcv_xskd.setAdapter(mAdapter = new BaseRecycleAdapter<ViewHolderFactory.ChooseGoodsResultHolder, XsKdBean>(mDetailResponseDataList, false) {

                    @Override
                    protected RecyclerView.ViewHolder MyonCreateViewHolder(ViewGroup parent) {
                        return ViewHolderFactory.getChooseGoodsResultHolder(mActivity, parent);
                    }

                    @Override
                    protected void MyonBindViewHolder(final ViewHolderFactory.ChooseGoodsResultHolder holder, final XsKdBean data) {

                        holder.tvGoodsInformation.setText(data.getGoodscode() + "  " + data.getGoodsname() + "  " + data.getSpecs() + "  " + data.getModel());
                        holder.tvRegistrationNumber.setText("￥：" + FigureTools.sswrFigure(data.getTaxunitprice())
                                + "*" + FigureTools.sswrFigure(data.getUnitqty()) + data.getUnitname()
                                + "        " + "￥" + data.getAmount());
                        holder.itemView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (true) {
                                    startActivityForResult(SpxqActivity.getMyIntent(mActivity, new Gson().toJson(data), tvFplx.getText().toString(), holder.getLayoutPosition()), 17);
                                } else {
                                    startActivity(new Intent(mActivity, SpxqCkActivity.class).putExtra("data", new Gson().toJson(data)));
                                }
                            }
                        });

                    }

                });
                if (mDetailResponseDataList != null) {
                    tvXzspsl.setText("共选择了" + mDetailResponseDataList.size() + "商品");
                }
                break;

            case 10001:
                if (TextUtils.isEmpty(data.toString())) {
                    Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show();
                    setResult(RESULT_OK);
                    finish();
                } else {
                    Toast.makeText(this, "删除失败:" + data.toString().substring(5), Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }


    private void setMasterData() {
        tvDjbh.setText(mMasterResponseData.getCode());
        switch (mMasterResponseData.getShzt()) {
            case 0:
                ivShzt.setBackgroundResource(R.drawable.wsh);
                break;
            case 1:
                ivShzt.setBackgroundResource(R.drawable.ysh);
                break;
            case 2:
                ivShzt.setBackgroundResource(R.drawable.shz);
                break;
        }
        tvCkck.setText(mMasterResponseData.getStorename());
        tvKh.setText(mMasterResponseData.getCname());
        tvLxr.setText(mMasterResponseData.getContator());
        etLxdh.setText(mMasterResponseData.getPhone());
        tvFplx.setText(mMasterResponseData.getBilltypename());
        tvSkrq.setText(mMasterResponseData.getSkrq());
        tvXm.setText(mMasterResponseData.getProjectname());
        etJhdz.setText(mMasterResponseData.getShipto());
        etKhqk.setText(FigureTools.sswrFigure(mMasterResponseData.getOweamt()));
        etHjje.setText(FigureTools.sswrFigure(mMasterResponseData.getTotalamt()));
        etSkje.setText(FigureTools.sswrFigure(mMasterResponseData.getReceipt()));
        tvSklx.setText(mMasterResponseData.getIspcname());
        tvZjzh.setText(mMasterResponseData.getBankname());
        tvWlgs.setText(mMasterResponseData.getLogisticname());
        tvDszh.setText(mMasterResponseData.getProxybankname());
        etDsje.setText(FigureTools.sswrFigure(mMasterResponseData.getProxyamt()));
        etSkhj.setText(FigureTools.sswrFigure(mMasterResponseData.getSumamt()));
        tvDjrq.setText(mMasterResponseData.getBilldate());
        tvBm.setText(mMasterResponseData.getDepname());
        tvYwy.setText(mMasterResponseData.getEmpname());
        tvZdr.setText(mMasterResponseData.getOpname());
        etBzxx.setText(mMasterResponseData.getMemo());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 9) {
                initVariables();
                setResult(RESULT_OK);
            }
        }
    }


}
