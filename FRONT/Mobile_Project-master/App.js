import React, { useEffect, useState } from 'react';
import LoadingScreen from './src/screens/LoadingScreen';
import { NativeWindStyleSheet } from "nativewind";
import Container from './src/screens/Container';
NativeWindStyleSheet.setOutput({
  default: "native",
});

export default function App() {

  const [isLoading, setIsLoading] = useState(true);
useEffect(() => {
  setTimeout(() => {
    setIsLoading(false);
  }, 4000);
},[])

  return (
      <>
        {isLoading?<LoadingScreen/>:
            <Container/>
        }
      </>
  );
}