package com.example.a.e.a.azkar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

public class Counter extends Azkar_Main {

    int counternum =1;
    TextView counter , fadlCCounter,head,progressText;
    LinearLayout linearLayout;
    Spinner spinner;
    ArrayAdapter<CharSequence> arrayAdapter;

    ProgressBar progressBar;

    FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout frameLayout = (FrameLayout)findViewById(R.id.frame_content);
        getLayoutInflater().inflate(R.layout.activity_counter,frameLayout);

        linearLayout= (LinearLayout) findViewById(R.id.counterBack);
        counter= (TextView)findViewById(R.id.counter);
        fadlCCounter= (TextView)findViewById(R.id.fadlCounter);
        head= (TextView)findViewById(R.id.head);
        progressText= (TextView)findViewById(R.id.progresstext);
        progressBar = (ProgressBar)findViewById(R.id.progresslenght);

        spinner = (Spinner)findViewById(R.id.spinner);


        arrayAdapter = ArrayAdapter.createFromResource(this,R.array.counterAzkar,R.layout.custom_simple_spinner_item);
        arrayAdapter.setDropDownViewResource(R.layout.custom_simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);







       /* relativeLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN){

                    //textView.setText(""+counter);
                    counter++;

                    if (counter==10){
                        counter=0;
                    }

                }
                return false;
            }
        });*/



    }




    @Override
    protected void onStart() {
        super.onStart();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int loc = (int) arrayAdapter.getItemId(position);
                final String zikr = arrayAdapter.getItem(position).toString();

                counternum=1;

                if (loc == 0) {

                }
                if (loc == 1) {

                    fadlCCounter.setText("من قالها 100 مرة : يكتب له ألف حسنة أو يحط عنه ألف خطيئة.");

                    if (zikr==zikr){
                        progressBar.setProgress(0);
                        counternum=1;
                    }

                    counter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            counter.setText("" + counternum);
                            counternum++;

                            progressText.setText(zikr);
                            progressBar.setMax(100);
                            int incrementNum = 0;
                            incrementNum++;
                            progressBar.incrementProgressBy(incrementNum);

                            if (counternum == 101) {
                                counternum = 1;
                                progressBar.setProgress(0);

                            }

                        }
                    });


                } else if (loc == 2) {

                    fadlCCounter.setText(" حُطَّتْ خَطَايَاهُ وَإِنْ كَانَتْ مِثْلَ زَبَدِ الْبَحْرِ. لَمْ يَأْتِ أَحَدٌ يَوْمَ الْقِيَامَةِ بِأَفْضَلَ مِمَّا جَاءَ بِهِ إِلَّا أَحَدٌ قَالَ مِثْلَ مَا قَالَ أَوْ زَادَ عَلَيْهِ.");

                    if (zikr==zikr){
                        progressBar.setProgress(0);
                        counternum=1;
                    }

                    counter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            counter.setText("" + counternum);
                            counternum++;

                            progressText.setText(zikr);
                            progressBar.setMax(100);
                            int incrementNum = 0;
                            incrementNum++;
                            progressBar.incrementProgressBy(incrementNum);


                            if (counternum == 101) {
                                counternum = 1;
                                progressBar.setProgress(0);

                            }

                        }
                    });

                } else if (loc == 3) {


                    fadlCCounter.setText(" تَمْلَآَنِ مَا بَيْنَ السَّمَاوَاتِ وَالْأَرْض ِ(أى عدد).");

                    if (zikr==zikr){
                        progressBar.setProgress(0);
                        counternum=1;
                    }


                    counter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            counter.setText("" + counternum);
                            counternum++;


                            progressText.setText(zikr);
                            progressBar.setMax(1000);
                            int incrementNum = 0;
                            incrementNum++;
                            progressBar.incrementProgressBy(incrementNum);



                            if (counternum == 1001) {

                                counternum = 1;
                                progressBar.setProgress(0);
                            }

                        }
                    });

                } else if (loc == 4) {


                    fadlCCounter.setText(" غرست له نخلة في الجنة (أى عدد).");

                    if (zikr==zikr){
                        progressBar.setProgress(0);
                        counternum=1;
                    }


                    counter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            counter.setText("" + counternum);
                            counternum++;

                            progressText.setText(zikr);
                            progressBar.setMax(1000);
                            int incrementNum = 0;
                            incrementNum++;
                            progressBar.incrementProgressBy(incrementNum);


                            if (counternum == 1001) {
                                counternum = 1;
                                progressBar.setProgress(0);

                            }

                        }
                    });
                }
                else if (loc == 5){

                    fadlCCounter.setText(" ثقيلتان في الميزان حبيبتان إلى الرحمن (أى عدد).");

                    if (zikr==zikr){
                        progressBar.setProgress(0);
                        counternum=1;
                    }


                    counter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            counter.setText(""+counternum);
                            counternum++;

                            progressText.setText(zikr);
                            progressBar.setMax(1000);
                            int incrementNum = 0;
                            incrementNum++;
                            progressBar.incrementProgressBy(incrementNum);


                            if (counternum==1001){
                                counternum = 1;
                                progressBar.setProgress(0);

                            }

                        }
                    });
                }
                else if (loc == 6){


                    fadlCCounter.setText(" كانت له عدل عشر رقاب، وكتبت له مئة حسنة، ومحيت عنه مئة سيئة، وكانت له حرزا من الشيطان.");

                    if (zikr==zikr){
                        progressBar.setProgress(0);
                        counternum=1;
                    }


                    counter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            counter.setText(""+counternum);
                            counternum++;

                            progressText.setText(zikr);
                            progressBar.setMax(100);
                            int incrementNum = 0;
                            incrementNum++;
                            progressBar.incrementProgressBy(incrementNum);


                            if (counternum==101){
                                counternum = 1;
                                progressBar.setProgress(0);

                            }

                        }
                    });
                }
                else if (loc == 7){


                    fadlCCounter.setText(" كنز من كنوز الجنة (أى عدد).");

                    if (zikr==zikr){
                        progressBar.setProgress(0);
                        counternum=1;
                    }


                    counter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            counter.setText(""+counternum);
                            counternum++;

                            progressText.setText(zikr);
                            progressBar.setMax(1000);
                            int incrementNum = 0;
                            incrementNum++;
                            progressBar.incrementProgressBy(incrementNum);


                            if (counternum==1001){
                                counternum = 1;
                                progressBar.setProgress(0);

                            }

                        }
                    });
                }
                else if (loc == 8){


                    fadlCCounter.setText(" تملأ ميزان العبد بالحسنات (أى عدد).");

                    if (zikr==zikr){
                        progressBar.setProgress(0);
                        counternum=1;
                    }


                    counter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            counter.setText(""+counternum);
                            counternum++;


                            progressText.setText(zikr);
                            progressBar.setMax(1000);
                            int incrementNum = 0;
                            incrementNum++;
                            progressBar.incrementProgressBy(incrementNum);

                            if (counternum==1001){
                                counternum = 1;
                                progressBar.setProgress(0);

                            }

                        }
                    });
                }
                else if (loc == 9){


                    fadlCCounter.setText(" من صلى على حين يصبح وحين يمسى ادركته شفاعتى يوم القيامة. ");

                    if (zikr==zikr){
                        progressBar.setProgress(0);
                        counternum=1;
                    }


                    counter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            counter.setText(""+counternum);
                            counternum++;

                            progressText.setText(zikr);
                            progressBar.setMax(1000);
                            int incrementNum = 0;
                            incrementNum++;
                            progressBar.incrementProgressBy(incrementNum);


                            if (counternum==1001){
                                counternum = 1;
                                progressBar.setProgress(0);

                            }

                        }
                    });
                }
                else if (loc == 10){


                    fadlCCounter.setText(" لفعل الرسول صلى الله عليه وسلم.");

                    if (zikr==zikr){
                        progressBar.setProgress(0);
                        counternum=1;
                    }


                    counter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            counter.setText(""+counternum);
                            counternum++;

                            progressText.setText(zikr);
                            progressBar.setMax(1000);
                            int incrementNum = 0;
                            incrementNum++;
                            progressBar.incrementProgressBy(incrementNum);


                            if (counternum==1001){
                                counternum = 1;
                                progressBar.setProgress(0);

                            }

                        }
                    });
                }
                else if (loc == 11){


                    fadlCCounter.setText("أنهن أحب الكلام الى الله، ومكفرات للذنوب، وغرس الجنة، وجنة لقائلهن من النار، وأحب الى النبي عليه السلام مما طلعت عليه الشمس، والْبَاقِيَاتُ الْصَّالِحَات (أى عدد).");

                    if (zikr==zikr){
                        progressBar.setProgress(0);
                        counternum=1;
                    }


                    counter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            counter.setText(""+counternum);
                            counternum++;

                            progressText.setText(zikr);
                            progressBar.setMax(1000);
                            int incrementNum = 0;
                            incrementNum++;
                            progressBar.incrementProgressBy(incrementNum);


                            if (counternum==1001){
                                counternum = 1;
                                progressBar.setProgress(0);

                            }

                        }
                    });
                }
                else if (loc == 12){


                    fadlCCounter.setText(" أفضل الذكر لا إله إلاّ الله (أى عدد).");

                    if (zikr==zikr){
                        progressBar.setProgress(0);
                        counternum=1;
                    }


                    counter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            counter.setText(""+counternum);
                            counternum++;

                            progressText.setText(zikr);
                            progressBar.setMax(1000);
                            int incrementNum = 0;
                            incrementNum++;
                            progressBar.incrementProgressBy(incrementNum);


                            if (counternum==1001){
                                counternum = 1;
                                progressBar.setProgress(0);

                            }

                        }
                    });
                }
                else if (loc == 13){


                    fadlCCounter.setText(" من قال الله أكبر كتبت له عشرون حسنة وحطت عنه عشرون سيئة. الله أكبر من كل شيء (أى عدد).");

                    if (zikr==zikr){
                        progressBar.setProgress(0);
                        counternum=1;
                    }


                    counter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            counter.setText(""+counternum);
                            counternum++;

                            progressText.setText(zikr);
                            progressBar.setMax(1000);
                            int incrementNum = 0;
                            incrementNum++;
                            progressBar.incrementProgressBy(incrementNum);


                            if (counternum==1001){
                                counternum = 1;
                                progressBar.setProgress(0);

                            }

                        }
                    });
                }
                else if (loc == 14){


                    fadlCCounter.setText(" في كل مره تحط عنه عشر خطايا ويرفع له عشر درجات ويصلي الله عليه عشرا وتعرض على الرسول صلى الله عليه وسلم (أى عدد). ");

                    if (zikr==zikr){
                        progressBar.setProgress(0);
                        counternum=1;
                    }


                    counter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            counter.setText(""+counternum);
                            counternum++;

                            progressText.setText(zikr);
                            progressBar.setMax(1000);
                            int incrementNum = 0;
                            incrementNum++;
                            progressBar.incrementProgressBy(incrementNum);


                            if (counternum==1001){
                                counternum = 1;
                                progressBar.setProgress(0);
                            }

                        }
                    });
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


}
