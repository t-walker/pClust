/**
 * @file
 *
 * @author jeff.daily@pnnl.gov
 *
 * Copyright (c) 2015 Battelle Memorial Institute.
 *
 * This file was converted to C code from the raw file found at
 * ftp://ftp.cbi.pku.edu.cn/pub/software/blast/matrices/PAM480, the
 * Center for Bioinformatics, Peking University, China.
 */
#ifndef _PARASAIL_PAM480_H_
#define _PARASAIL_PAM480_H_

#include "parasail.h"
#include "pam_map.h"

/* # */
/* # This matrix was produced by "pam" Version 1.0.6 [28-Jul-93] */
/* # */
/* # PAM 480 substitution matrix, scale = ln(2)/7 = 0.0990210 */
/* # */
/* # Expected score = -0.494, Entropy = 0.0893 bits */
/* # */
/* # Lowest score = -10, Highest score = 35 */
/* # */

static const int parasail_pam480_[] = {
/*        A   R   N   D   C   Q   E   G   H   I   L   K   M   F   P   S   T   W   Y   V   B   Z   X   * */
/* A */   1, -1,  1,  1, -2,  0,  1,  2,  0,  0, -2,  0, -1, -4,  1,  1,  1, -7, -4,  0,  1,  0,  0,-10,
/* R */  -1,  5,  1,  0, -4,  2,  0, -1,  2, -2, -3,  4,  0, -5,  0,  0,  0,  4, -4, -2,  0,  1,  0,-10,
/* N */   1,  1,  1,  2, -4,  1,  2,  1,  1, -1, -3,  1, -1, -4,  0,  1,  0, -5, -3, -1,  2,  1,  0,-10,
/* D */   1,  0,  2,  3, -5,  2,  3,  1,  1, -2, -3,  1, -2, -6,  0,  1,  0, -7, -5, -1,  2,  2,  0,-10,
/* C */  -2, -4, -4, -5, 22, -5, -5, -3, -4, -2, -6, -6, -5, -4, -3,  0, -2,-10,  2, -2, -4, -5, -3,-10,
/* Q */   0,  2,  1,  2, -5,  3,  2,  0,  3, -2, -2,  1, -1, -5,  1,  0,  0, -5, -4, -1,  2,  2,  0,-10,
/* E */   1,  0,  2,  3, -5,  2,  3,  1,  1, -2, -3,  1, -2, -5,  0,  1,  0, -8, -5, -1,  2,  3,  0,-10,
/* G */   2, -1,  1,  1, -3,  0,  1,  4, -1, -2, -4, -1, -2, -5,  1,  1,  1, -8, -5, -1,  1,  1,  0,-10,
/* H */   0,  2,  1,  1, -4,  3,  1, -1,  5, -2, -2,  1, -1, -2,  0,  0,  0, -3,  0, -2,  1,  2,  0,-10,
/* I */   0, -2, -1, -2, -2, -2, -2, -2, -2,  4,  4, -2,  3,  2, -1, -1,  0, -5,  0,  3, -2, -2,  0,-10,
/* L */  -2, -3, -3, -3, -6, -2, -3, -4, -2,  4,  7, -3,  5,  4, -2, -2, -1, -2,  1,  3, -3, -3, -1,-10,
/* K */   0,  4,  1,  1, -6,  1,  1, -1,  1, -2, -3,  4,  0, -5,  0,  0,  0, -3, -5, -2,  1,  1,  0,-10,
/* M */  -1,  0, -1, -2, -5, -1, -2, -2, -1,  3,  5,  0,  4,  1, -1, -1,  0, -4, -1,  2, -2, -1,  0,-10,
/* F */  -4, -5, -4, -6, -4, -5, -5, -5, -2,  2,  4, -5,  1, 14, -5, -4, -3,  3, 13,  0, -5, -5, -2,-10,
/* P */   1,  0,  0,  0, -3,  1,  0,  1,  0, -1, -2,  0, -1, -5,  5,  1,  1, -6, -5, -1,  0,  1,  0,-10,
/* S */   1,  0,  1,  1,  0,  0,  1,  1,  0, -1, -2,  0, -1, -4,  1,  1,  1, -3, -3, -1,  1,  0,  0,-10,
/* T */   1,  0,  0,  0, -2,  0,  0,  1,  0,  0, -1,  0,  0, -3,  1,  1,  1, -6, -3,  0,  0,  0,  0,-10,
/* W */  -7,  4, -5, -7,-10, -5, -8, -8, -3, -5, -2, -3, -4,  3, -6, -3, -6, 35,  2, -7, -6, -6, -4,-10,
/* Y */  -4, -4, -3, -5,  2, -4, -5, -5,  0,  0,  1, -5, -1, 13, -5, -3, -3,  2, 16, -2, -4, -5, -2,-10,
/* V */   0, -2, -1, -1, -2, -1, -1, -1, -2,  3,  3, -2,  2,  0, -1, -1,  0, -7, -2,  3, -1, -1,  0,-10,
/* B */   1,  0,  2,  2, -4,  2,  2,  1,  1, -2, -3,  1, -2, -5,  0,  1,  0, -6, -4, -1,  2,  2,  0,-10,
/* Z */   0,  1,  1,  2, -5,  2,  3,  1,  2, -2, -3,  1, -1, -5,  1,  0,  0, -6, -5, -1,  2,  2,  0,-10,
/* X */   0,  0,  0,  0, -3,  0,  0,  0,  0,  0, -1,  0,  0, -2,  0,  0,  0, -4, -2,  0,  0,  0,  0,-10,
/* * */ -10,-10,-10,-10,-10,-10,-10,-10,-10,-10,-10,-10,-10,-10,-10,-10,-10,-10,-10,-10,-10,-10,-10,  1
};

static const parasail_matrix_t parasail_pam480 = {
    "pam480",
    parasail_pam480_,
    parasail_pam_map,
    24,
    0
};

#endif /* _PARASAIL_PAM480_H_ */
