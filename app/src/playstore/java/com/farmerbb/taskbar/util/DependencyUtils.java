/* Copyright 2017 Braden Farmer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.farmerbb.taskbar.util;

import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.farmerbb.taskbar.R;
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity;
import com.mikepenz.iconics.Iconics;

public class DependencyUtils {

    private DependencyUtils() {}

    public static CharSequence getKeyboardShortcutSummary(Context context) {
        return new Iconics.IconicsBuilder()
                .ctx(context)
                .on(context.getString(R.string.pref_description_keyboard_shortcut))
                .build();
    }

    static ToastInterface createToast(Context context, String message, int length) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1)
            return new ToastFrameworkImpl(context, message, length);
        else
            return new ToastCompatImpl(context, message, length);
    }

    public static void showLicenses(Context context) {
        Intent intent = new Intent(context, OssLicensesMenuActivity.class);
        context.startActivity(intent);
    }
}
