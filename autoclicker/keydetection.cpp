#include <iostream>
#include <windows.h>

// create keyboard hook
HHOOK k_hook;
LRESULT __stdcall k_Callback1(int nCode, WPARAM wParam, LPARAM lParam)
{
    PKBDLLHOOKSTRUCT key = (PKBDLLHOOKSTRUCT) lParam;

    // if a key is pressed
    if (wParam == WM_KEYDOWN && nCode == HC_ACTION) {
        switch (key -> vkCode) {
            // keybind is the .> key (period/greater than)
            case VK_OEM_PERIOD:
                std::cout << "OEM_PERIOD pressed" << std::endl;
                break;
            // terminate key (numpad0)
            case VK_NUMPAD0:
                UnhookWindowsHookEx(k_hook);
                std::cout << "Program terminated (numpad0 detected)" << std::endl;
                PostQuitMessage(0);
                return 0;
        }
    }

    return CallNextHookEx(NULL, nCode, wParam, lParam);
}

int main()
{
    // keyboard hook instance
    k_hook = SetWindowsHookExA(WH_KEYBOARD_LL, k_Callback1, NULL, 0);
    // run program until stopped
    MSG msg;
    while (GetMessage(&msg, NULL, 0, 0) != 0) {
        
    }

    return 0;
}