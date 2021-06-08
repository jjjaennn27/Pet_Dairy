# 반려동물 앱 "부탁해, 집사 !" 🐕 🐈
## 1.소개

### 1-1 개발배경
 
간식으로 인한 비만 또는 산책을 안함으로써 생기는 배변 장애 등 반려동물에게 흔히 나타나는 건강문제이다. 이를 해결하기 위해서는 가족의 의사소통과 무한한 관심이 중요하다. 그러나, 반려동물을 키우는 입장에서 혼자가 아닌 가족 구성원과 함께 관심을 가지고 모두가 케어해야 한다고 생각한다. 이러한 문제점을 토대로 기존 어플을 조사해보니 반려동물에 대한 어플 중 아직까지 가족들과 함께 공유할 수 있는 앱이 존재하지 않은 것을 확인하였다. 그 후 반려동물에 관한 앱을 개발함으로써 많은 집사들에게 활용적이게 사용할 수 있는 앱이 될 것 같아 주제를 선정하였다.
### 1-2 사용한 기능
부탁해 집사! 서비스 애플리케이션은 모든 가족 구성원끼리 반려동물을 케어 할 수 있게 가족연동을 통하여 반려동물들의 밥, 간식, 건강, 산책 등의 정보를 실시간으로 공유할 수 있다. 또한 google맵과 연동을 통하여 내 주변에 공원 위치와 병원 위치를 알 수 있게 함으로서 모든 집사들이 책임감을 가지고 반려동물을 편리하게 서비스를 제공 하는 것을 목표로 구성하였다.
Firebase을 Android Studio와 연결하여 테이터 저장을 통하여 여러 기능들을 구현하고 , 등Google API 연동을 통해 실시간 위치와 Place API을 이용하여 공원 위치와 병원 위치를 찾을 수 있도록 한다.
### 1-3 기존 어플과의 차이

### 1-4 기대효과

많은 가구에서 반려동물을 키우고 있어 반려동물 관리에 많은 관심이 쏟아지고 있는 요즘, 다양하게 반려동물에 대한 용품이나 그밖의 여러가지 관리를 위한것들이 나타나고 있다. 이에 걸맞게 많은 가구에서 유용하게 쓰여질 수 있는 반려동물 관리 어플을 만듬으로써 직접적으로 소통을 하지 않고도 정보 입력을 통해 서로 내용들을 공유하고 번거로움을 줄일 수 있으며 검색을 하지 않고도 주변 병원 또한 찾아볼 수 있어  가족 구성원이 좀 더 효율적으로 동물들을 보살필수 있을것이다. 그뿐만아니라 가족구성원이 각자 사진을 올리고 글을 작성하면서 가족간의 소통의 기회 또한 늘어나게 해줄것이라 기대한다.

## 2. 기능 구현

### 2-1 사용자 생성
#### 2-1-1 Firebase와 Android Studio 연동
 회원가입과 로그인 및 건강,산책,다이어리,가족연동 을 위해 데이터를 저장해 놓을 Firebase가 필요하다.
 
[연동 방법] 
1. 파이어 베이스에 프로젝트 생성
2. google-service.json파일얻기
3. .json파일을 안드로이드스튜디오 프로젝트 안에 삽입 
4. Firebase SDK추가
5. 안드로이드와 파이어베이스 연결 확인

[연동방법- realtime database]
1. TOOL에들어간후, 파이어베이스 클릭
2. realtime database를 찾은 후 클릭
3. Connect firebase를 하여 생성한 파이어베이스와 연동
4. add to realtime database to your app 을 클릭하여 자동으로 build.gradle에 코드가 추가되게 만들어줌


#### 2-1-2 회원가입
이메일로 회원가입을 진행할 수 있도록 하였다. 사용자의 이메일, 비밀번호를 입력하여 저장하여, 파이어베이스에 정보가 올라갈 수 있고도록 만들었다.


    public class Register extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabaseRef;
    private EditText mEtEmail,mEtpwd;
    private Button mBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Family login"); //파이어베이스에 회원가입 정보 저장

        mEtEmail = findViewById(R.id.et_email);
        mEtpwd = findViewById(R.id.et_pwd);
        mBtnRegister = findViewById(R.id.btn_register);

        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //회원가입 처리시작
                String strEmail = mEtEmail.getText().toString();
                String strPwd = mEtpwd.getText().toString();

                //파이어베이즈 어스 진행
                mFirebaseAuth.createUserWithEmailAndPassword(strEmail,strPwd).addOnCompleteListener(
                        Register.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if(task.isSuccessful()){
                            FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                            UserAccount account = new UserAccount();
                            account.setIdToken(firebaseUser.getUid());
                            account.setEmailId(firebaseUser.getEmail());
                            account.setPassword(strPwd);

                            mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(account);

                            Toast.makeText(Register.this,"회원가입에 성공하셨습니다.",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Register.this,Login.class); //회원가입 성공시 로그인 화면 전환 
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(Register.this,"회원가입에 실패하셨습니다.",Toast.LENGTH_SHORT).show();
                            //회원가입 실패시 토스트 메시지 출력
                        }
                    }
                });
            }
        });
    }
    }

![image](https://user-images.githubusercontent.com/51051548/121134546-79c76300-c86e-11eb-8771-622d1352e113.png)



