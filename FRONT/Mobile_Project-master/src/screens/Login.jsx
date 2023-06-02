import {Text,SafeAreaView, Pressable,Image,View,TextInput,TouchableWithoutFeedback, Keyboard} from 'react-native';
import LoginStore from '../stores/LoginStore';
const Login = () => {
    const {isLogged,changeLogState}=LoginStore();
    return ( 
        <>
        <TouchableWithoutFeedback onPress={Keyboard.dismiss} accessible={false}>
            <SafeAreaView>
                <View className="h-full w-full flex items-center justify-center pb-20">
                    <Image 
                    className="my-5"
                    style={{ width: 100, height: 100 }}
                    source={require("../Icons/LoginLogo.png")}
                    />
                    <Text className="w-4/5 py-3 text-base font-medium ">Email</Text>
                    <TextInput
                    className="bg-slate-50 p-3 w-4/5 mb-5"
                    onChangeText={()=>{}}
                    placeholder="Votre email"
                    keyboardType="default"
                    />
                    <Text className="w-4/5 py-3 text-base font-medium ">Password</Text>
                    <TextInput
                    className="bg-slate-50 px-2 py-3 w-4/5"
                    onChangeText={()=>{}}
                    placeholder="Votre mot de passe"
                    keyboardType="default"
                    />
                    <Pressable className="bg-sky-500 my-10 rounded" onPress={()=>{changeLogState()}}>
                        <Text className=" text-white font-semibold px-10 py-2">Login</Text>
                    </Pressable>
                </View>
            </SafeAreaView>
        </TouchableWithoutFeedback>
    </>
    );
}
export default Login;