import React, { useState } from 'react';
import { Text ,View , TouchableWithoutFeedback, Keyboard  , TextInput, Pressable , StyleSheet , Image , ActivityIndicator ,ScrollView , Dimensions,Alert} from "react-native";
import { Icon } from 'react-native-elements';
import * as ImagePicker from 'expo-image-picker';
import { storage } from '../firebase/firebaseConfig';
import { ref, uploadBytes, getDownloadURL } from 'firebase/storage';
import { API_URL } from '@env';

const AddAnnonce = () => {
    const [selectedAsset,setAsset]=useState();
    const [selectedImage, setSelectedImage] = useState(null);
    const [PostTitle,setPostTitle]=useState();
    const [PostDetails,setPostDetails]=useState();
    const [categorieId,setCatgorieId]=useState();
    const [phone,setPhoneNum]=useState();
    const [price,setPrice]=useState();
    const [uploading, setUploading] = useState(false);

    const selectImage = async () => {
        const result = await ImagePicker.launchImageLibraryAsync();
            if (!result.canceled) {
            const { assets } = result;
            const selectedAsset = assets[0];
            setSelectedImage(selectedAsset.uri); 
            setAsset(selectedAsset)
            }
    };
    async function sendPost(){
        if (!selectedAsset) {
            Alert.alert('Alert !', 'Aucun image selectionee', [
                {text: 'OK'},
              ]);
            return;
        }
        setUploading(true)
        // uploading image to firebase
        // Get the file name from the selected asset
        const fileName = selectedAsset.fileName;
        
        // Create a Firebase Storage reference
        const storageRef = ref(storage,'images/'+ fileName);
        try {
            // Upload the file to Firebase Storage
            const response = await fetch(selectedAsset.uri);
            const blob = await response.blob();
            await uploadBytes(storageRef, blob);
    
            console.log('Image uploaded successfully');
    
            // Get the public download URL of the uploaded image
            const downloadURL = await getDownloadURL(storageRef);
            console.log('Download URL:', downloadURL);
            // calling our spring api created by faroui ismail 
            setUploading(false)
            const annonce = {
                image: downloadURL,
                title: PostTitle,
                category: "Èlectronique",
                progress: "AVAILABLE",
                price:price,
                phone:phone,
                about:PostDetails,
                location: null,
                userId: null
            }
            const requestOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(annonce)
            };
            fetch(`${API_URL}/api/annonce`, requestOptions)
                .then(response =>{ 
                    response.json()
                    console.log(response)
                    setUploading(false)
                })
                .then(data => {
                    console.log(data)
                });
        } catch (error) {
            console.log('Error uploading image:', error);
        }
    }

    return (
        <TouchableWithoutFeedback onPress={Keyboard.dismiss} accessible={false}>
                <View>
                <ScrollView>
                    <View  className="flex gap-y-1.5 my-auto h-full mx-4">
                        <Pressable onPress={()=>{sendPost()}} className="flex self-end px-3.5 py-2 rounded bg-white items-end ">
                            <Text className="text-base text-blue-500 font-semibold">Publier</Text>
                        </Pressable>
                        <Text className="text-base font-medium my-0.5">Titre</Text>
                        <TextInput
                        onChangeText={(title)=>{setPostTitle(title)}}
                        className="bg-white p-3 rounded"
                        placeholder="Titre de votre annonce"
                        keyboardType="default"
                        />
                        <Text className="text-base font-medium my-1">Téléphone</Text>
                        <TextInput
                        className="bg-white p-3 rounded"
                        onChangeText={(phone)=>{setPhoneNum(phone)}}
                        placeholder="Tapez votre numéro"
                        keyboardType="default"
                        />
                        <Text className="text-base font-medium my-1">Prix</Text>
                        <TextInput
                        className="bg-white p-3 rounded"
                        onChangeText={(price)=>{setPrice(price)}}
                        placeholder="Tapez votre prix"
                        keyboardType="numeric"
                        />
                        {selectedImage ? (
                            <Pressable
                            className="flex flex-col justify-center items-center bg-white border border-dashed"
                            onPress={()=>{selectImage(null)}}
                            >
                            <Image source={{ uri: selectedImage }} className="w-full h-36" />
                            </Pressable>
                            ) : (
                            <Pressable
                                className="flex flex-col justify-center items-center bg-white p-10 border border-dashed"
                                onPress={selectImage}
                            >
                                <Icon className="pr-2" name="image" type="font-awesome" size={20} color="#2563EB" />
                                <Text>select image</Text>
                            </Pressable>
                        )}
                        <Text className="text-base font-medium">Description</Text>
                        <TextInput
                        multiline
                        style={styles.textTop}
                        className="bg-white h-36 mb-2 p-4 rounded-sm"
                        onChangeText={(PostDetails)=>{setPostDetails(PostDetails)}}
                        placeholder="Détails de votre produit"
                        keyboardType="default"
                        />
                    </View> 
                </ScrollView>
            {
                        uploading?
                        <View style={styles.activityIndicatorContainer}>
                        <ActivityIndicator size="large" color="#ffff" />
                        </View>:null
            }
                </View>
        </TouchableWithoutFeedback>
    );
}
 const styles = StyleSheet.create({
    textTop:{
        textAlignVertical: 'top',
    },
    activityIndicatorContainer: {
        position: 'absolute',
        top: 0,
        left: 0,
        right: 0,
        bottom: 0,
        alignItems: 'center',
        justifyContent: 'center',
        backgroundColor: 'rgba(0, 0, 0, 0.8)',
        zIndex: 9999,
        height:Dimensions.get('window').height
    },
 })

export default AddAnnonce;