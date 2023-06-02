import React, { useState , useRef , useEffect} from 'react';
import { StyleSheet  } from 'react-native';
import { FlatGrid } from 'react-native-super-grid';
import ProductCard from '../components/ProductCard';
import ProductModal from '../components/ProductModal';
import { API_URL } from '@env';

const HomeScreen = (props) => {
    const modalRef = useRef(null);
    const [products,setProducts]=useState([]);
    const callModalFunction = (product) => {
        modalRef.current?.modalFunction(product);
    };
    useEffect(()=>{
      fetch(`${API_URL}/api/annonce`)
      .then(response => response.json())
      .then(data => {
          setProducts(data)
      });
    },[products])
    return (     
        <>
            <FlatGrid
                className="mx-0.5"
                itemDimension={130}
                style={styles.gridView}
                data={products}
                spacing={1}
                renderItem={({ item }) => (
                    <ProductCard
                    onPress={()=>{callModalFunction(item)}}
                    title={item.title}
                    ImageSource={{uri:item.image}}
                    />
                )}
            />
            <ProductModal ref={modalRef}/>
        </>
            
    );
}

const styles = StyleSheet.create({
    gridView: {
        flex: 1,
        backgroundColor:'#E2E8F0'
    },
});

export default HomeScreen;