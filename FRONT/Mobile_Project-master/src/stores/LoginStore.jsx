import { create } from 'zustand'

const LoginStore = create((set) => ({
    isLogged: false,
    changeLogState: () => set((state) => ({ isLogged: true })),
}))

export default LoginStore;