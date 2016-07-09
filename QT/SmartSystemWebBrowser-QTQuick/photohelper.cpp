#include "photohelper.h"

PhotoHelper::PhotoHelper(QString path)
{
    count = 0 ;
    photoHome = path ;
    photoHomeDir = QDir(photoHome);
    reSetImagePaths() ;
}
